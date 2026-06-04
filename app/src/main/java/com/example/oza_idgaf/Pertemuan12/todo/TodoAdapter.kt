package com.example.oza_idgaf.Pertemuan12.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oza_idgaf.Pertemuan12.data.TodoEntity
import com.example.oza_idgaf.databinding.ItemTodoBinding

class TodoAdapter(
    private val todos: List<TodoEntity>,
    private val onUpdate: (TodoEntity) -> Unit,
    private val onDelete: (TodoEntity) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.binding.cbTodo.text = todo.task

        // Menghindari trigger loop saat inisiasi state checkbox
        holder.binding.cbTodo.setOnCheckedChangeListener(null)
        holder.binding.cbTodo.isChecked = todo.isCompleted

        holder.binding.cbTodo.setOnCheckedChangeListener { _, isChecked ->
            onUpdate(todo.copy(isCompleted = isChecked))
        }

        holder.binding.btnDeleteTodo.setOnClickListener {
            onDelete(todo)
        }
    }

    override fun getItemCount(): Int = todos.size
}