package com.example.projectoangel.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "horario")
data class Horario(
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val IDUsuario:Int
)