package com.sesar.fe_todo.view

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sesar.fe_todo.databinding.ActivityMainBinding
import com.sesar.fe_todo.databinding.DialogEditTodoBinding
import com.sesar.fe_todo.viewmodel.TodoViewModel
import com.sesar.fe_todo.adapter.TodoAdapter
import com.sesar.fe_todo.databinding.DialogConfirmDeleteBinding
import com.sesar.fe_todo.databinding.DialogCreateTodoBinding
import com.sesar.fe_todo.model.Todo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TodoViewModel
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        binding.viewModel = viewModel

        setupRecyclerView()
        setupAddButton()

        viewModel.todos.observe(this, { todos ->
            adapter.setTodos(todos)
        })

        viewModel.fetchTodos()
    }

    private fun setupRecyclerView() {
        adapter = TodoAdapter(
            onEdit = { todo -> showEditDialog(todo) },
            onDelete = { todo -> viewModel.deleteTodo(todo.id) }
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupAddButton() {
        binding.buttonAddTodo.setOnClickListener {
            showCreateDialog()
        }
    }

    private fun showCreateDialog() {
        val dialogBinding = DialogCreateTodoBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Create Todo")
            .setView(dialogBinding.root)
            .setPositiveButton("Create") { _, _ ->
                val newTodo = Todo(
                    id = 0, // This will be ignored by the server and replaced with the actual ID
                    title = dialogBinding.editTextTitle.text.toString(),
                    description = dialogBinding.editTextDescription.text.toString(),
                    createdAt = "", // The server will set this
                    updatedAt = ""  // The server will set this
                )
                viewModel.createTodo(newTodo)
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }

    private fun showEditDialog(todo: Todo) {
        val dialogBinding = DialogEditTodoBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Edit Todo")
            .setView(dialogBinding.root)
            .setPositiveButton("Save") { _, _ ->
                val updatedTodo = todo.copy(
                    title = dialogBinding.editTextTitle.text.toString(),
                    description = dialogBinding.editTextDescription.text.toString()
                )
                viewModel.updateTodo(todo.id, updatedTodo)
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialogBinding.editTextTitle.setText(todo.title)
        dialogBinding.editTextDescription.setText(todo.description)
        dialog.show()
    }

    private fun showDeleteDialog(todo: Todo) {
        val dialogBinding = DialogConfirmDeleteBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Delete Todo")
            .setView(dialogBinding.root)
            .setPositiveButton("Delete") { _, _ ->
                viewModel.deleteTodo(todo.id)
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }
}