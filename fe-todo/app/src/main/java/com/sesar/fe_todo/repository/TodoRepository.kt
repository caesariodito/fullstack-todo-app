package com.sesar.fe_todo.repository

import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.network.RetrofitInstance
import retrofit2.await

class TodoRepository {

    private val api = RetrofitInstance.api

    suspend fun getTodos(): List<Todo> {
        return api.getTodos().await()
    }
}