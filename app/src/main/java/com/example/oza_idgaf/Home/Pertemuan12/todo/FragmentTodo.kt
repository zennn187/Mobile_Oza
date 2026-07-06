package com.example.oza_idgaf.Home.Pertemuan12.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oza_idgaf.Home.Pertemuan12.data.AppDatabase
import com.example.oza_idgaf.Home.Pertemuan12.data.TodoEntity
import com.example.oza_idgaf.databinding.FragmentTodoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentTodo : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TodoAdapter
    private lateinit var db: AppDatabase
    private val todos = mutableListOf<TodoEntity>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = AppDatabase.getInstance(requireContext())
        adapter = TodoAdapter(todos, this)

        binding.rvTodos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTodos.adapter = adapter

        binding.btnAddTask.setOnClickListener {
            val taskText = binding.etTodo.text.toString()
            if (taskText.isNotBlank()) {
                val todo = TodoEntity(task = taskText)

                lifecycleScope.launch(Dispatchers.IO) {
                    db.todoDao().insert(todo)
                    withContext(Dispatchers.Main) {
                        // FIX: Use safe call or setText to avoid nullable receiver error
                        binding.etTodo.setText("")
                        fetchTodos()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Tugas tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }

        fetchTodos()
    }

    private fun fetchTodos() {
        lifecycleScope.launch(Dispatchers.IO) {
            val data = db.todoDao().getAllTodos()
            withContext(Dispatchers.Main) {
                todos.clear()
                todos.addAll(data)
                adapter.notifyDataSetChanged()
            }
        }
    }

    fun updateTodo(todo: TodoEntity) {
        lifecycleScope.launch(Dispatchers.IO) {
            db.todoDao().update(todo)
        }
    }

    fun deleteTodo(todo: TodoEntity) {
        lifecycleScope.launch(Dispatchers.IO) {
            db.todoDao().delete(todo)
            withContext(Dispatchers.Main) {
                fetchTodos()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
