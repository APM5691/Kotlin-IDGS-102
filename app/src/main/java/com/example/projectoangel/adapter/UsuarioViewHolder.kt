package com.example.projectoangel.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectoangel.R
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.models.Usuario
import com.example.projectoangel.usuario.UsuarioMenu
import com.example.projectoangel.usuario.UsuarioEditar

class UsuarioViewHolder(view: View) :RecyclerView.ViewHolder(view){

    val usuariotexto = view.findViewById<TextView>(R.id.textUsuario)
    val usuariofecha = view.findViewById<TextView>(R.id.fechaNac)
    val usuariocorreo = view.findViewById<TextView>(R.id.correo)
    val btnEditar = view.findViewById<Button>(R.id.btnEditarUsuario)
    val btnBorrar = view.findViewById<Button>(R.id.btnBorrarUsuario)

    fun render(usuario: Usuario){
        usuariotexto.text = usuario.Nombre + " " + usuario.ApellidoPaterno + " " + usuario.ApellidoMaterno
        usuariofecha.text = usuario.FechaNacimiento
        usuariocorreo.text = usuario.Correo
    }

    fun edit(usuario: Int,cn: Context){
        btnEditar.setOnClickListener{
            var database = AppDatabase.getDatabase(cn)

            var tare=database.usuarios().get(usuario)

            val intent = Intent(cn, UsuarioEditar::class.java).apply {
                putExtra("key",tare)
            }

            cn.startActivity(intent)
        }
    }

    fun delet(usuario: Usuario,cn: Context){
        btnBorrar.setOnClickListener{
            var database = AppDatabase.getDatabase(cn)

            database.usuarios().delete(usuario)

            val intent = Intent(cn, UsuarioMenu::class.java)
            cn.startActivity(intent)
        }
    }

}