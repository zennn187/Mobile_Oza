package com.example.oza_idgaf.Pertemuan12.note

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oza_idgaf.Pertemuan12.data.AppDatabase
import com.example.oza_idgaf.Pertemuan12.data.NoteEntity
import com.example.oza_idgaf.databinding.FragmentNoteBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentNote : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: NoteAdapter
    private lateinit var db: AppDatabase
    private val notes = mutableListOf<NoteEntity>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = AppDatabase.getInstance(requireContext())
        adapter = NoteAdapter(notes, this)

        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = adapter
        binding.rvNotes.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }
    }

    fun fetchNotes() {
        lifecycleScope.launch(Dispatchers.IO) {
            val data = db.noteDao().getAllNotes()
            withContext(Dispatchers.Main) {
                notes.clear()
                notes.addAll(data)
                adapter.notifyDataSetChanged()
            }
        }
    }

    fun deleteNote(note: NoteEntity) {
        lifecycleScope.launch(Dispatchers.IO) {
            db.noteDao().delete(note)
            withContext(Dispatchers.Main) {
                fetchNotes()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}