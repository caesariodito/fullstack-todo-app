package com.sesar.fe_todo.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sesar.fe_todo.R
import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.viewmodel.TodoViewModel
import kotlinx.coroutines.runBlocking

class TodoDetailActivity : AppCompatActivity() {

    private lateinit var homeViewModel: TodoViewModel
    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var buttonSave: Button
    private var todoId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_detail)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextDescription = findViewById(R.id.editTextDescription)
        buttonSave = findViewById(R.id.buttonSave)

        homeViewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        todoId = intent.getLongExtra("todo_id", -1)
        if (todoId != -1L) {
            homeViewModel.getTodoById(todoId!!).observe(this) { todo ->
                editTextTitle.setText(todo.title)
                editTextDescription.setText(todo.description)
            }
        }

        buttonSave.setOnClickListener {
            runBlocking {
                saveTodo()
                finish()
            }
        }
    }

    private suspend fun saveTodo() {
        val title = editTextTitle.text.toString()
        val description = editTextDescription.text.toString()

        if (todoId != null && todoId != -1L) {
            val updatedTodo = Todo(todoId!!, title, description, "", "")
            homeViewModel.updateTodo(updatedTodo)
        }
    }
}

