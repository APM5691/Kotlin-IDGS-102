package com.example.projectoangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectoangel.databinding.ActivityMenuApiBinding
import com.example.projectoangel.tarea.TareaMenu
import com.example.projectoangel.usuario.UsuarioMenu

class MenuApi : AppCompatActivity() {

    lateinit var binding: ActivityMenuApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUsuario.setOnClickListener {
            val intent = Intent(this, UsuarioMenu::class.java)
            startActivity(intent)
        }

        binding.btnTarea.setOnClickListener{
            val intent = Intent(this, TareaMenu::class.java)
            startActivity(intent)
        }
    }
}