package com.example.projectoangel.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projectoangel.R
import com.example.projectoangel.models.Tarea

class TareaViewHolder(view: View) :RecyclerView.ViewHolder(view){

    val tareatexto = view.findViewById<TextView>(R.id.textTarea)
    fun render(tarea:Tarea){
        tareatexto.text = tarea.Nombre
    }
}