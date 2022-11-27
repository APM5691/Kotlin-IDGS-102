package com.example.projectoangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectoangel.adapter.TareaAdapter
import com.example.projectoangel.databinding.ActivityTareaMenuBinding
import com.example.projectoangel.models.Tarea
import com.example.projectoangel.viewmodel.MainViewModel

class TareaMenu : AppCompatActivity() {
    lateinit var binding: ActivityTareaMenuBinding
    lateinit var viewModel: MainViewModel

    var Tareas = listOf<Tarea>(
        Tarea(1,"Tarea 1","Tarea 1","22/05/2001","22/05/2001"),
        Tarea(2,"Tarea 2","Tarea 2","22/05/2001","22/05/2001"),
                Tarea(1,"Tarea 1","Tarea 1","22/05/2001","22/05/2001"),
    Tarea(2,"Tarea 2","Tarea 2","22/05/2001","22/05/2001"),
    Tarea(1,"Tarea 1","Tarea 1","22/05/2001","22/05/2001"),
    Tarea(2,"Tarea 2","Tarea 2","22/05/2001","22/05/2001"),
    Tarea(1,"Tarea 1","Tarea 1","22/05/2001","22/05/2001"),
    Tarea(2,"Tarea 2","Tarea 2","22/05/2001","22/05/2001"),
    Tarea(1,"Tarea 1","Tarea 1","22/05/2001","22/05/2001"),
    Tarea(2,"Tarea 2","Tarea 2","22/05/2001","22/05/2001"),
    Tarea(1,"Tarea 1","Tarea 1","22/05/2001","22/05/2001"),
    Tarea(2,"Tarea 2","Tarea 2","22/05/2001","22/05/2001"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTareaMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.crearTarea.setOnClickListener{
            val intent = Intent(this,TareaCrear::class.java)
            startActivity(intent)
        }
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.ListaTarea)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TareaAdapter(Tareas)
    }
}