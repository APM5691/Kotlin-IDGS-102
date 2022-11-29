package com.example.projectoangel.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projectoangel.models.Usuario

@Dao
interface UsuariosDao {
    @Query("SELECT * FROM usuarios")
    fun getAll():List<Usuario>

    @Query("SELECT * FROM usuarios WHERE ID = :id")
    fun get(id:Int):Usuario

    @Insert
    fun insert(vararg usuario: Usuario)

    @Update
    fun update(vararg usuario: Usuario)

    @Delete
    fun delete(vararg usuario: Usuario)
}