package com.example.oza_idgaf.Pertemuan12.note

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.oza_idgaf.Pertemuan12.data.AppDatabase
import com.example.oza_idgaf.Pertemuan12.data.NoteEntity
import com.example.oza_idgaf.databinding.ActivityNoteFormBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.btnSaveNote.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()

            if (title.isNotBlank() && content.isNotBlank()) {
                val note = NoteEntity(
                    title = title,
                    content = content,
                    createdAt = System.currentTimeMillis()
                )

                lifecycleScope.launch(Dispatchers.IO) {
                    db.noteDao().insert(note)

                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@NoteFormActivity, "Catatan berhasil disimpan!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } else {
                Toast.makeText(this, "Judul dan konten tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}