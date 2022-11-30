package com.example.projectoangel.models

import java.io.Serializable

data class Actividad(
    val id: Int,
    val nombre:String,
    val descripcion:String,
    val fecha_de_inicio:String,
    val fecha_de_termino: String
): Serializable