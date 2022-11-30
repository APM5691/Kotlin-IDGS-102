package com.example.projectoangel

import android.content.Intent
import android.content.SharedPreferences
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

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        //var id = sharedpreferences.getString("id", "")

        binding.CerrarSesion.setOnClickListener{
            editor.clear().apply();
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

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