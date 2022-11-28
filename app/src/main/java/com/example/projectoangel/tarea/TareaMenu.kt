package com.example.projectoangel.tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectoangel.adapter.TareaAdapter
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.databinding.ActivityTareaMenuBinding
import com.example.projectoangel.models.Tarea

class TareaMenu : AppCompatActivity() {
    lateinit var binding: ActivityTareaMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTareaMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.crearTarea.setOnClickListener{
            val intent = Intent(this, TareaCrear::class.java)
            startActivity(intent)
        }


    }

    fun initRecyclerView(){
        val recyclerView = binding.ListaTarea
        recyclerView.layoutManager = LinearLayoutManager(this)

        var Tareas = emptyList<Tarea>()

        var insertTareas = listOf<Tarea>(
            Tarea(0,"Tarea 1","Tarea 1","22/05/2001","22/05/2001"),
            Tarea(0,"Tarea 2","Tarea 2","22/05/2001","22/05/2001"),
        )

            var database = AppDatabase.getDatabase(this)

            //database.tareas().insert(insertTareas)

            Tareas = database.tareas().getAll()

            Log.d("message", Tareas.toString())


        recyclerView.adapter = TareaAdapter(Tareas,this)
    }
}