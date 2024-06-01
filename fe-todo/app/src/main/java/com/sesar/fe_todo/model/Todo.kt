package com.sesar.fe_todo.model

//import java.time.LocalDateTime

data class Todo(
    val id: Long,
    val title: String,
    val description: String,
    val createdAt: String,
    val updatedAt: String
)