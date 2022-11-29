package com.example.projectoangel.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityUsuarioCrearBinding
import com.example.projectoangel.models.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioCrear : AppCompatActivity() {

    lateinit var binding: ActivityUsuarioCrearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioCrearBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Crear.setOnClickListener{
            var tar : Usuario = getAllData()

            var database = AppDatabase.getDatabase(this)
            CoroutineScope(Dispatchers.IO).launch {
               database.usuarios().insert(tar)
            }

            println(tar)

            val intent = Intent(this, UsuarioMenu::class.java)
            startActivity(intent)
        }
    }

    fun getAllData(): Usuario
    {
        var usuario : Usuario =
            Usuario(0,
                   binding.TextNombre.text.toString(),
                   binding.ApellidoP.text.toString(),
                   binding.ApellidoM.text.toString(),
                   binding.FechaNacimiento.text.toString(),
                   binding.correo.text.toString(),
                   binding.password.text.toString()
            )
        return usuario
    }
}