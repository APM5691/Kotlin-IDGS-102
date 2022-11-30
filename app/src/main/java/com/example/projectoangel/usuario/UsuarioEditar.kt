package com.example.projectoangel.usuario

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projectoangel.Main
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityUsuarioEditarBinding
import com.example.projectoangel.models.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class UsuarioEditar: AppCompatActivity()  {

    lateinit var binding: ActivityUsuarioEditarBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding=ActivityUsuarioEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        //var id = sharedpreferences.getString("id", "")

        binding.button19.setOnClickListener{
            editor.clear().apply();
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

        val usuario = intent.getSerializableExtra("key") as Usuario

        val textNombre: TextView = binding.TextNombre
        textNombre.text = usuario.Nombre
        
        val textApellidoP: TextView = binding.ApellidoP
        textApellidoP.text = usuario.ApellidoPaterno
        
        val textApellidoM: TextView = binding.ApellidoM
        textApellidoM.text = usuario.ApellidoMaterno
        
        val textFechaNacimiento: TextView = binding.FechaNacimiento
        textFechaNacimiento.text = usuario.FechaNacimiento
        
        val textcorreo: TextView = binding.correo
        textcorreo.text = usuario.Correo
        
        val textpassword: TextView = binding.password
        textpassword.text = usuario.Password

        binding.Crear.setOnClickListener{
            var tar : Usuario = getAllData(usuario.ID)

            var database = AppDatabase.getDatabase(this)

            Log.d("message",tar.toString())

            CoroutineScope(Dispatchers.IO).launch {
                database.usuarios().update(tar)
            }

            val intent = Intent(this, UsuarioMenu::class.java)
            startActivity(intent)
        }
    }

    fun getAllData(id:Int): Usuario
    {
        var usuario : Usuario =
            Usuario(id,
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