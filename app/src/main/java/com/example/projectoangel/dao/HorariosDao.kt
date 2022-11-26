package com.example.projectoangel.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projectoangel.models.Horario

@Dao
interface HorariosDao {
    @Query("SELECT * FROM horario")
    suspend fun getAll():List<Horario>

    @Query("SELECT * FROM horario WHERE ID = :id")
    suspend fun get(id:Int):List<Horario>

    @Insert
     fun insert(horario: List<Horario>):List<Long>

    @Update
    suspend fun update(vararg horario: Horario)
}