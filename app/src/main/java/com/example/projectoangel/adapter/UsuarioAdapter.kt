package com.example.projectoangel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectoangel.R
import com.example.projectoangel.models.Usuario

class UsuarioAdapter(private val listaUsuario:List<Usuario>,cn: Context) : RecyclerView.Adapter<UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuarioViewHolder(layoutInflater.inflate(R.layout.item_usuario,parent,false))
    }

    val cpn = cn

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val item = listaUsuario[position]
        holder.render(item)
        holder.edit(item.ID,cpn)
        holder.delet(item,cpn)
    }

    override fun getItemCount(): Int = listaUsuario.size

}