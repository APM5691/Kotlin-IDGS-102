package com.example.projectoangel.tarea

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectoangel.Main
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

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        //var id = sharedpreferences.getString("id", "")

        binding.button15.setOnClickListener{
            editor.clear().apply();
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

        binding.crearTarea.setOnClickListener{
            val intent = Intent(this, TareaCrear::class.java)
            startActivity(intent)
        }


    }

    fun initRecyclerView(){
        val recyclerView = binding.ListaTarea
        recyclerView.layoutManager = LinearLayoutManager(this)

        var Tareas = emptyList<Tarea>()


            var database = AppDatabase.getDatabase(this)

            //database.tareas().insert(insertTareas)

            Tareas = database.tareas().getAll()

            Log.d("message", Tareas.toString())


        recyclerView.adapter = TareaAdapter(Tareas,this)
    }
}