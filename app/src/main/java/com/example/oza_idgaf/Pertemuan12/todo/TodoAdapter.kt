package com.example.oza_idgaf.Pertemuan12.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oza_idgaf.Pertemuan12.data.TodoEntity
import com.example.oza_idgaf.databinding.ItemTodoBinding // Pastikan Anda membuat file item_todo.xml

class TodoAdapter(
    private val todos: List<TodoEntity>,
    private val todoFragment: FragmentTodo
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.binding.tvTodoTask.text = todo.task
        holder.binding.cbDone.isChecked = todo.isCompleted

        holder.binding.cbDone.setOnCheckedChangeListener { _, isChecked ->
            todoFragment.updateTodo(todo.copy(isCompleted = isChecked))
        }

        holder.binding.btnDeleteTodo.setOnClickListener {
            todoFragment.deleteTodo(todo)
        }
    }

    override fun getItemCount(): Int = todos.size
}