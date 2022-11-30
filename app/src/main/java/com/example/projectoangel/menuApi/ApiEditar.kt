package com.example.projectoangel.menuApi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectoangel.Main
import com.example.projectoangel.databinding.ActivityApiEditarBinding
import com.example.projectoangel.models.Actividad
import com.example.projectoangel.models.Tarea
import com.google.gson.Gson

class ApiEditar : AppCompatActivity() {
    lateinit var binding: ActivityApiEditarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        //var id = sharedpreferences.getString("id", "")

        binding.btnCerrarSesion.setOnClickListener{
            editor.clear().apply();
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

        val Act = intent.getSerializableExtra("key") as Actividad

        binding.txtApiCrearNom.setText(Act.nombre)

        binding.txtApiCrearDesc.setText(Act.descripcion)

        binding.txtApiCrearFecIni.setText(Act.fecha_de_inicio)

        binding.txtApiCrearFecFin.setText(Act.fecha_de_termino)

        binding.btnApiEditar.setOnClickListener{

                val queue = Volley.newRequestQueue(this)
                val sr: StringRequest = object : StringRequest(
                    Method.PUT, "http://192.168.1.75:8000/api/actividades/",
                    Response.Listener { response ->
                        Log.d("message", response)
                    },
                    Response.ErrorListener { error ->
                        Log.d("message", "error $error")
                    }) {
                    override fun getParams(): Map<String, String> {
                        val params: MutableMap<String, String> = HashMap()
                        params["id"] = Act.id.toString()
                        params["nombre"] = binding.txtApiCrearNom.text.toString()
                        params["descripcion"] =  binding.txtApiCrearDesc.text.toString()
                        params["fecha_de_inicio"] = binding.txtApiCrearFecIni.text.toString()
                        params["fecha_de_termino"] = binding.txtApiCrearFecFin.text.toString()
                        //Log.d("message", params.toString())
                        return params
                    }

                }
                queue.add(sr)
                val intent = Intent(this, ApiMenu::class.java)
                startActivity(intent)
        }
    }
}