package com.example.projectoangel.tarea

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projectoangel.Main
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityTareaEditarBinding
import com.example.projectoangel.models.Tarea
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class TareaEditar: AppCompatActivity()  {

    lateinit var binding: ActivityTareaEditarBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding=ActivityTareaEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        //var id = sharedpreferences.getString("id", "")

        binding.button19.setOnClickListener{
            editor.clear().apply();
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

        val tarea = intent.getSerializableExtra("key") as Tarea

        val textNombre: TextView = binding.TextNombre
        textNombre.text = tarea.Nombre

        val textDescripcion: TextView = binding.TextDescripcion
        textDescripcion.text = tarea.Descripcion

        val textFC: TextView = binding.FechaCreacion
        textFC.text = tarea.Nombre

        val textFT: TextView = binding.FechaTermino
        textFT.text = tarea.FechaTermino

        binding.Crear.setOnClickListener{
            var tar : Tarea = getAllData(tarea.ID)

            var database = AppDatabase.getDatabase(this)

            Log.d("message",tar.toString())

            CoroutineScope(Dispatchers.IO).launch {
                database.tareas().update(tar)
            }

            val intent = Intent(this, TareaMenu::class.java)
            startActivity(intent)
        }
    }

    fun getAllData(id:Int): Tarea
    {
        var tarea : Tarea =
            Tarea(id,
                binding.TextNombre.text.toString(),
                binding.TextDescripcion.text.toString(),
                binding.FechaCreacion.text.toString(),
                binding.FechaTermino.text.toString())
        return tarea
    }
}