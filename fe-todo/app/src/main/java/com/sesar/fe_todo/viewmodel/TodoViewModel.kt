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
    private val _todo = MutableLiveData<Todo>()
    val todos: LiveData<List<Todo>> get() = _todos

    init {
        fetchTodos()
    }

    fun fetchTodos() {
        viewModelScope.launch {
            try {
                val fetchedTodos = repository.getTodos()
                _todos.postValue(fetchedTodos)
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error fetching todos", e)
            }
        }
    }

    fun getTodoById(id: Long): LiveData<Todo> {
        viewModelScope.launch {
            try {
                _todo.value = repository.getTodoById(id)
            } catch (e: Exception) {
                Log.e("TodoViewModel", "Error fetching todo", e)
            }
        }
        return _todo
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

    suspend fun updateTodo(todo: Todo) {
        try {
            Log.d("TodoViewModel updatetodo","_todos BEFORE: ${_todos.value}")
            val updatedTodo = repository.updateTodo(todo.id, todo)
            Log.d("1 updatetodo","_todos BEFORE: ${_todos.value}")
            val currentTodos = _todos.value?.toMutableList() ?: mutableListOf()
            Log.d("2 updatetodo","_todos BEFORE: ${_todos.value}")
            val index = currentTodos.indexOfFirst { it.id == todo.id }
            Log.d("3 updatetodo","_todos BEFORE: ${_todos.value}")
            if (index != -1) {
                currentTodos[index] = updatedTodo
            } else {
                currentTodos.add(updatedTodo)
            }
            Log.d("4 updatetodo","_todos BEFORE: ${_todos.value}")
            _todos.value = currentTodos
            Log.d("TodoViewModel updatetodo","_todos AFTER: ${todos.value}")
        } catch (e: Exception) {
            Log.e("TodoViewModel", "Error updating todo", e)
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
