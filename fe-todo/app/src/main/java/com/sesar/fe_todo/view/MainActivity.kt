package com.sesar.fe_todo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sesar.fe_todo.R
import com.sesar.fe_todo.databinding.ActivityMainBinding
import com.sesar.fe_todo.viewmodel.TodoViewModel
import com.sesar.fe_todo.adapter.TodoAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TodoViewModel
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        binding.viewModel = viewModel

        setupRecyclerView()

        viewModel.todos.observe(this) { todos ->
            adapter.setTodos(todos)
            Log.d("MainActivity", "Todos observed: $todos")
        }

        viewModel.fetchTodos()
    }

    private fun setupRecyclerView() {
        adapter = TodoAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}