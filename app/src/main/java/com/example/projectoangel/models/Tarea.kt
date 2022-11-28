package com.example.projectoangel.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tarea")
data class Tarea(
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val Nombre:String,
    val Descripcion:String,
    val FechaCreacion:String,
    val FechaTermino: String
): Serializable