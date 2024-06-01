package com.sesar.fe_todo.network
import com.sesar.fe_todo.model.Todo

import retrofit2.http.*
import retrofit2.Response

interface TodoApiService {
    @GET("todos/")
    suspend fun getTodos(): List<Todo>

    @GET("todos/{id}")
    suspend fun getTodoById(@Path("id") id: Long): Todo

    @POST("todos/")
    suspend fun createTodo(@Body todo: Todo): Todo

    @PUT("todos/{id}")
    suspend fun updateTodo(@Path("id") id: Long, @Body todo: Todo): Todo

    @DELETE("todos/{id}")
    suspend fun deleteTodo(@Path("id") id: Long): Response<Unit>
}