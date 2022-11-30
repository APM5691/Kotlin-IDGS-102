package com.example.projectoangel

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityMainBinding


class Main : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()

        editor.clear().apply();

        var usuario = binding.usuario.text.toString()

        var password = binding.password.text.toString()

        binding.button.setOnClickListener{

            var database = AppDatabase.getDatabase(this)

            var Usuarios = database.usuarios().getAll()

            var usuario = binding.usuario.text.toString()

            var password = binding.password.text.toString()

            for (i in Usuarios){
                if (i.Correo == usuario && i.Password == password){
                    editor.putString("id", i.ID.toString()).commit()
                    val intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Sesion Iniciada", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

}