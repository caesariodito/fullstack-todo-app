package com.sesar.fe_todo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesar.fe_todo.databinding.ItemTodoBinding
import com.sesar.fe_todo.model.Todo

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ToDoViewHolder>()  {

    private var todos: List<Todo> = listOf()

    inner class ToDoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todo = todos[position]
        holder.binding.todo = todo
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = todos.size

    @SuppressLint("NotifyDataSetChanged")
    fun setTodos(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }
}