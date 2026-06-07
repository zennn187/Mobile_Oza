package com.example.oza_idgaf.Pertemuan12.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: NoteEntity): Long

    @Update
    fun update(note: NoteEntity): Int

    @Delete
    fun delete(note: NoteEntity): Int

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteEntity>
}