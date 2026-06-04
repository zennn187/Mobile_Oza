package com.example.oza_idgaf.Pertemuan12.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos")
    suspend fun getAll(): List<TodoEntity>

    @Insert
    fun insert(todo: TodoEntity)

    @Update
    fun update(todo: TodoEntity)

    @Delete
    fun delete(todo: TodoEntity)
}