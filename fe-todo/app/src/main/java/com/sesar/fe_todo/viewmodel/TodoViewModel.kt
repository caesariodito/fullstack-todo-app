package com.sesar.fe_todo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.repository.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TodoRepository()

    private val _todos = MutableLiveData<List<Todo>>()
    val todos: LiveData<List<Todo>> get() = _todos

    private fun refreshTodos(newTodos: List<Todo>) {
        _todos.postValue(newTodos)
        Log.d("TodoViewModel", "Current todos: $newTodos")
    }

    fun fetchTodos() {
        viewModelScope.launch {
            try {
                val fetchedTodos = repository.getTodos()
                refreshTodos(fetchedTodos)
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error fetching todos", e)
            }
        }
    }

    fun createTodo(todo: Todo) {
        viewModelScope.launch {
            try {
                val newTodo = repository.createTodo(todo)
                val currentTodos = _todos.value?.toMutableList() ?: mutableListOf()
                currentTodos.add(newTodo)
                refreshTodos(currentTodos)
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error creating todo", e)
            }
        }
    }

    fun updateTodo(id: Long, todo: Todo) {
        viewModelScope.launch {
            try {
                val updatedTodo = repository.updateTodo(id, todo)
                val currentTodos = _todos.value?.toMutableList() ?: mutableListOf()
                val index = currentTodos.indexOfFirst { it.id == id }
                if (index >= 0) {
                    currentTodos[index] = updatedTodo
                    refreshTodos(currentTodos)
                }
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error updating todo", e)
            }
        }
    }

    fun deleteTodo(id: Long) {
        viewModelScope.launch {
            try {
                val currentTodos = _todos.value?.toMutableList() ?: mutableListOf()
                repository.deleteTodo(id)
                currentTodos.removeAll { it.id == id }
                refreshTodos(currentTodos)
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error deleting todo", e)
            }
        }
    }
}
