package com.example.projectoangel.tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityTareaCrearBinding
import com.example.projectoangel.models.Tarea
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TareaCrear : AppCompatActivity() {

    lateinit var binding: ActivityTareaCrearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTareaCrearBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Crear.setOnClickListener{
            var tar : Tarea = getAllData()

            var database = AppDatabase.getDatabase(this)
            CoroutineScope(Dispatchers.IO).launch {
               database.tareas().insert(tar)
            }

            println(tar)

            val intent = Intent(this, TareaMenu::class.java)
            startActivity(intent)
        }
    }

    fun getAllData(): Tarea
    {
        var tarea : Tarea =
            Tarea(0,
                   binding.TextNombre.text.toString(),
                   binding.TextDescripcion.text.toString(),
                   binding.FechaCreacion.text.toString(),
                   binding.FechaTermino.text.toString())
        return tarea
    }
}