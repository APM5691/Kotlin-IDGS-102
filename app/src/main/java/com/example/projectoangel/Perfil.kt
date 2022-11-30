package com.example.projectoangel

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityPerfilBinding
import com.example.projectoangel.databinding.ActivityTareaMenuBinding

class Perfil : AppCompatActivity() {

    lateinit var binding : ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        
        var id = sharedpreferences.getString("id", "")

        var database = AppDatabase.getDatabase(this)

        var Usuario = database.usuarios().get(id!!.toInt())

        binding.nombre.setText(Usuario.Nombre)
        binding.apellidoP.setText(Usuario.ApellidoPaterno)
        binding.apellidoM.setText(Usuario.ApellidoMaterno)
        binding.coreo.setText(Usuario.Correo)
        binding.FechaNac.setText(Usuario.FechaNacimiento)

        binding.cerrarSesion.setOnClickListener{
            editor.clear().apply();
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }
    }
}