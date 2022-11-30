package com.example.projectoangel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectoangel.R
import com.example.projectoangel.models.Actividad

class ActividadAdapter(private val listaActividad:List<Actividad>,cn: Context) : RecyclerView.Adapter<ActividadViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActividadViewHolder(layoutInflater.inflate(R.layout.item_api,parent,false))
    }

    val cpn = cn

    override fun onBindViewHolder(holder: ActividadViewHolder, position: Int) {
        val item = listaActividad[position]
        holder.render(item)
        holder.edit(item.id,cpn)
        holder.delet(item.id,cpn)
    }

    override fun getItemCount(): Int = listaActividad.size

}