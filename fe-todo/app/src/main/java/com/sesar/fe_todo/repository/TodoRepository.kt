package com.sesar.fe_todo.repository

import android.util.Log
import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.network.RetrofitInstance
import retrofit2.Response

class TodoRepository {

    private val api = RetrofitInstance.api

    suspend fun getTodos(): List<Todo> {
        return try {
            api.getTodos()
        } catch (e: Exception) {
            Log.e("TodoRepository", "Failed to fetch todos: ${e.message}", e)
            throw Exception("Failed to fetch todos: ${e.message}", e)
        }
    }

    suspend fun createTodo(todo: Todo): Todo {
        return try {
            api.createTodo(todo)
        } catch (e: Exception) {
            Log.e("TodoRepository", "Failed to create todo: ${e.message}", e)
            throw Exception("Failed to create todo: ${e.message}", e)
        }
    }

    suspend fun updateTodo(id: Long, todo: Todo): Todo {
        return try {
            api.updateTodo(id, todo)
        } catch (e: Exception) {
            Log.e("TodoRepository", "Failed to update todo: ${e.message}", e)
            throw Exception("Failed to update todo: ${e.message}", e)
        }
    }

    suspend fun deleteTodo(id: Long) {
        try {
            val response: Response<Unit> = api.deleteTodo(id)
            if (!response.isSuccessful) {
                throw Exception("Failed to delete todo: ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("TodoRepository", "Failed to delete todo: ${e.message}", e)
            throw Exception("Failed to delete todo: ${e.message}", e)
        }
    }
}
