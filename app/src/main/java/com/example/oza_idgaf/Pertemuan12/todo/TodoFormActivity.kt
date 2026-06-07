package com.example.oza_idgaf.Pertemuan12.todo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.Pertemuan12.data.AppDatabase
import com.example.oza_idgaf.Pertemuan12.data.TodoEntity
import com.example.oza_idgaf.databinding.ActivityTodoFormBinding

class TodoFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTodoFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.btnSaveTodo.setOnClickListener {
            val title = binding.etTitleTodo.text.toString()

            if (title.isNotBlank()) {
                val todo = TodoEntity(
                    task = title
                )
                db.todoDao().insert(todo)
                finish()
            } else {
                Toast.makeText(this, "Harap isi judul tugas!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}