package com.example.projectoangel.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projectoangel.models.Tarea

@Dao
interface TareasDao {
    @Query("SELECT * FROM tarea")
    fun getAll():List<Tarea>

    @Query("SELECT * FROM tarea WHERE ID = :id")
    fun get(id:Int):Tarea

    @Insert
    fun insert(vararg tarea: Tarea)

    @Update
    fun update(vararg tarea: Tarea)

    @Delete
    fun delete(vararg tarea: Tarea)
}