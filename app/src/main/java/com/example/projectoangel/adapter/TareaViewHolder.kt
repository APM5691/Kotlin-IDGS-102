package com.example.projectoangel.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectoangel.R
import com.example.projectoangel.tarea.TareaMenu
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.models.Tarea
import com.example.projectoangel.tarea.TareaEditar

class TareaViewHolder(view: View) :RecyclerView.ViewHolder(view){

    val tareatexto = view.findViewById<TextView>(R.id.textUsuario)
    val btnEditar = view.findViewById<Button>(R.id.btnEditarUsuario)
    val btnBorrar = view.findViewById<Button>(R.id.btnBorrarUsuario)

    fun render(tarea: Tarea){
        tareatexto.text = tarea.Nombre
    }

    fun edit(tarea: Int,cn: Context){
        btnEditar.setOnClickListener{
            var database = AppDatabase.getDatabase(cn)

            //Log.d("message", tarea.toString())
            var tare=database.tareas().get(tarea)
            //Log.d("message", tare.toString())

            val intent = Intent(cn, TareaEditar::class.java).apply {
                putExtra("key",tare)
            }

            cn.startActivity(intent)
        }
    }

    fun delet(tarea: Tarea,cn: Context){
        btnBorrar.setOnClickListener{
            var database = AppDatabase.getDatabase(cn)

            database.tareas().delete(tarea)

            val intent = Intent(cn, TareaMenu::class.java)
            cn.startActivity(intent)
        }
    }

}