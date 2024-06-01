package com.sesar.fe_todo.repository

import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.network.RetrofitInstance
import retrofit2.await
import retrofit2.Response
import retrofit2.awaitResponse

class TodoRepository {

    private val api = RetrofitInstance.api

    suspend fun getTodos(): List<Todo> {
        return try {
            api.getTodos()
        } catch (e: Exception) {
            throw Exception("Failed to fetch todos: ${e.message}", e)
        }
    }
}