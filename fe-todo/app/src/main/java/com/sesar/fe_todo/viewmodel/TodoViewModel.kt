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
}