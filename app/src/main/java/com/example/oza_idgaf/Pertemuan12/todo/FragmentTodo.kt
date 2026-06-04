package com.example.oza_idgaf.Pertemuan12.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oza_idgaf.Pertemuan12.data.AppDatabase
import com.example.oza_idgaf.Pertemuan12.data.TodoEntity
import com.example.oza_idgaf.databinding.FragmentTodoBinding
import kotlinx.coroutines.launch

class FragmentTodo : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var adapter: TodoAdapter
    private val todoList = mutableListOf<TodoEntity>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())

        adapter = TodoAdapter(
            todoList,
            onUpdate = { todo -> updateTodo(todo) },
            onDelete = { todo -> deleteTodo(todo) }
        )

        binding.rvTodos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTodos.adapter = adapter

        binding.btnAddTask.setOnClickListener {
            val taskName = binding.etTodo.text.toString()
            if (taskName.isNotBlank()) {
                lifecycleScope.launch {
                    db.todoDao().insert(TodoEntity(task = taskName))
                    binding.etTodo.text.clear()
                    fetchTodos()
                }
            } else {
                Toast.makeText(context, "Tulis tugas terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }

        fetchTodos()
    }

    private fun fetchTodos() {
        lifecycleScope.launch {
            val data = db.todoDao().getAll()
            todoList.clear()
            todoList.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    private fun updateTodo(todo: TodoEntity) {
        lifecycleScope.launch {
            db.todoDao().update(todo)
            fetchTodos()
        }
    }

    private fun deleteTodo(todo: TodoEntity) {
        lifecycleScope.launch {
            db.todoDao().delete(todo)
            fetchTodos()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}