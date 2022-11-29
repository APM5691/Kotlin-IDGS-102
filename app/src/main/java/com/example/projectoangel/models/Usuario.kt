package com.example.projectoangel.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val Nombre:String,
    val ApellidoPaterno:String,
    val ApellidoMaterno:String,
    val FechaNacimiento: String,
    val Correo: String,
    val Password: String
): Serializable