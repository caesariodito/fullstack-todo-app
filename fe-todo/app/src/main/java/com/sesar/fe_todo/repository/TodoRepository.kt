package com.sesar.fe_todo.repository

import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.network.RetrofitInstance

class TodoRepository {

    private val api = RetrofitInstance.api

    suspend fun getTodos(): List<Todo> {
        return try {
            api.getTodos()
        } catch (e: Exception) {
            throw Exception("Failed to fetch todos: ${e.message}", e)
        }
    }

    suspend fun createTodo(todo: Todo): Todo {
        return try {
            api.createTodo(todo)
        } catch (e: Exception) {
            throw Exception("Failed to create todo: ${e.message}", e)
        }
    }

    suspend fun updateTodo(id: Long, todo: Todo): Todo {
        return try {
            api.updateTodo(id, todo)
        } catch (e: Exception) {
            throw Exception("Failed to update todo: ${e.message}", e)
        }
    }

    suspend fun deleteTodo(id: Long) {
        try {
            api.deleteTodo(id)
        } catch (e: Exception) {
            throw Exception("Failed to delete todo: ${e.message}", e)
        }
    }
}