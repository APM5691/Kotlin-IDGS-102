package com.example.projectoangel.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectoangel.adapter.UsuarioAdapter
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityUsuarioMenuBinding
import com.example.projectoangel.models.Usuario

class UsuarioMenu : AppCompatActivity() {
    lateinit var binding: ActivityUsuarioMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.crearUsuario.setOnClickListener{
            val intent = Intent(this, UsuarioCrear::class.java)
            startActivity(intent)
        }

    }

    fun initRecyclerView(){
        val recyclerView = binding.ListaUsuario
        recyclerView.layoutManager = LinearLayoutManager(this)

        var Usuarios = emptyList<Usuario>()

        var database = AppDatabase.getDatabase(this)


         Usuarios = database.usuarios().getAll()

         Log.d("message", Usuarios.toString())


        recyclerView.adapter = UsuarioAdapter(Usuarios,this)
    }
}