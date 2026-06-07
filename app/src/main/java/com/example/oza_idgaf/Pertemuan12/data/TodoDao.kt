package com.example.oza_idgaf.Pertemuan12.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: TodoEntity): Long

    @Update
    fun update(todo: TodoEntity): Int
    @Delete
    fun delete(todo: TodoEntity): Int

    @Query("SELECT * FROM todos")
    fun getAllTodos(): List<TodoEntity>
}