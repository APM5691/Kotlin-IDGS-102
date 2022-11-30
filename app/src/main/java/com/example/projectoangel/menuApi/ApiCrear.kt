package com.example.projectoangel.menuApi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectoangel.databinding.ActivityApiCrearBinding
import com.example.projectoangel.models.Actividad
import java.nio.charset.Charset

class ApiCrear : AppCompatActivity() {
    lateinit var binding: ActivityApiCrearBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiCrearBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnApiCreated.setOnClickListener{
            val queue = Volley.newRequestQueue(this)
            val sr: StringRequest = object : StringRequest(Method.POST, "http://192.168.1.75:8000/api/actividades/",
                Response.Listener { response ->
                    Log.d("message", response)
                },
                Response.ErrorListener { error ->
                    Log.d("message", "error $error")
                }) {
                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
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