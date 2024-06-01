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

    fun fetchTodos() {
        viewModelScope.launch {
            try {
                val fetchedTodos = repository.getTodos()
                _todos.value = fetchedTodos
                // Print fetched data to the console
                Log.d("TodoViewModel", "Fetched Todos: $fetchedTodos")
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
                _todos.postValue(currentTodos)
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
                    _todos.postValue(currentTodos)
                }
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error updating todo", e)
            }
        }
    }

    fun deleteTodo(id: Long) {
        viewModelScope.launch {
            try {
                repository.deleteTodo(id)
                val currentTodos = _todos.value?.toMutableList() ?: mutableListOf()
                currentTodos.removeAll { it.id == id }
                _todos.postValue(currentTodos)
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error deleting todo", e)
            }
        }
    }
}