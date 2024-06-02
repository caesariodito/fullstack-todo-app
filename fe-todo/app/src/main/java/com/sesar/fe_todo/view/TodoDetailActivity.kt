package com.sesar.fe_todo.view

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sesar.fe_todo.databinding.ActivityTodoDetailBinding
import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.viewmodel.TodoDetailViewModel

class TodoDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoDetailBinding
    private lateinit var viewModel: TodoDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TodoDetailViewModel::class.java)

        val todoId: Long = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getLongExtra("todo_id", 0L)
        } else {
            @Suppress("DEPRECATION")
            intent.getLongExtra("todo_id", 0L)
        }

        viewModel.fetchTodoDetail(todoId)

        viewModel.todo.observe(this, { todo ->
            if (todo != null) {
                binding.todoTitle.text = todo.title
                binding.todoDescription.text = todo.description
            }
        })
    }
}
