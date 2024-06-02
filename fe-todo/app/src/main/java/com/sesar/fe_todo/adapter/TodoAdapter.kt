package com.sesar.fe_todo.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesar.fe_todo.databinding.ItemTodoBinding
import com.sesar.fe_todo.model.Todo
import com.sesar.fe_todo.view.TodoDetailActivity

class TodoAdapter(
    private val onEdit: (Todo) -> Unit,
    private val onDelete: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private var todos = listOf<Todo>()

    @SuppressLint("NotifyDataSetChanged")
    fun setTodos(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size

    inner class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.todo = todo
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                val context = it.context
                val intent = Intent(context, TodoDetailActivity::class.java)
                intent.putExtra("todo_id", todo.id)
                context.startActivity(intent)
            }

            binding.editButton.setOnClickListener { onEdit(todo) }
            binding.deleteButton.setOnClickListener { onDelete(todo) }
        }
    }
}