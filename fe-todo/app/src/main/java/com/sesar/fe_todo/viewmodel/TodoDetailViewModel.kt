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

class TodoDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TodoRepository()

    private val _todo = MutableLiveData<Todo>()
    val todo: LiveData<Todo> get() = _todo

    fun fetchTodoDetail(id: Long) {
        viewModelScope.launch {
            try {
                val fetchedTodo = repository.getTodoById(id)
                _todo.postValue(fetchedTodo)
            } catch (e: Exception) {
                Log.e("TodoDetailViewModel", "Error fetching todo detail", e)
            }
        }
    }
}
