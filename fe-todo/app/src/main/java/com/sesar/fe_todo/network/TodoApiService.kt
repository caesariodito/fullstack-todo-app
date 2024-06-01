package com.sesar.fe_todo.network
import com.sesar.fe_todo.model.Todo

import retrofit2.http.*
import retrofit2.Call

interface TodoApiService {
    @GET("todos/")
    fun getTodos(): Call<List<Todo>>

    @GET("todos/{id}")
    fun getTodoById(@Path("id") id: Long): Todo

    @POST("todos/")
    fun addTodo(@Body todo: Todo): Todo

    @PUT("todos/{id}")
    fun updateTodo(@Path("id") id: Long, @Body todo: Todo): Todo

    @DELETE("todos/{id}")
    fun deleteTodo(@Path("id") id: Long): Void
}