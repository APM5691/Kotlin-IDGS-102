package com.example.projectoangel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectoangel.R
import com.example.projectoangel.models.Tarea

class TareaAdapter(private val listaTarea:List<Tarea>,cn: Context) : RecyclerView.Adapter<TareaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TareaViewHolder(layoutInflater.inflate(R.layout.item_tarea,parent,false))
    }
    val cpn = cn
    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val item = listaTarea[position]
        holder.render(item)
        holder.edit(item.ID,cpn)
        holder.delet(item,cpn)
    }

    override fun getItemCount(): Int = listaTarea.size


}