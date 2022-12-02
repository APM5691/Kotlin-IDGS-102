package com.example.projectoangel.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectoangel.R
import com.example.projectoangel.config.AppDatabase
import com.example.projectoangel.menuApi.ApiEditar
import com.example.projectoangel.menuApi.ApiMenu
import com.example.projectoangel.models.Actividad
import com.google.gson.Gson
import org.json.JSONObject

class ActividadViewHolder(view: View) :RecyclerView.ViewHolder(view){

    val nombre = view.findViewById<TextView>(R.id.txtApiNombre)
    val descipcion = view.findViewById<TextView>(R.id.txtApiDescripcion)
    val fechaIni = view.findViewById<TextView>(R.id.txtApiFecIni)
    val fechaFin = view.findViewById<TextView>(R.id.txtApiFecFin)

    val btnEditar = view.findViewById<Button>(R.id.btnApiEditar)
    val btnBorrar = view.findViewById<Button>(R.id.btnApiBorrar)

    fun render(act: Actividad){
        nombre.text = act.nombre
        descipcion.text = act.descripcion
        fechaIni.text  = act.fecha_de_inicio
        fechaFin.text  =act.fecha_de_termino
    }

    fun edit(actividad: Int,cn: Context){
        btnEditar.setOnClickListener{

                // Instantiate the RequestQueue.
                val queue = Volley.newRequestQueue(cn)
                val url = "https://proyectodecimo-sn96l.ondigitalocean.app/api/actividades/"+actividad

                var Act : Actividad
                val stringRequest = StringRequest(
                    Request.Method.GET, url,
                    { response ->
                        val json = JSONObject(response)
                        var json2 = json.getJSONObject("response")
                        //Log.d("message", json2.toString())
                        Act = Gson().fromJson(json2.toString(), Actividad::class.java)

                        //Log.d("message", Act.toString())

                        val intent = Intent(cn, ApiEditar::class.java).apply {
                            putExtra("key",Act)
                        }

                        cn.startActivity(intent)
                    },
                    {
                        Log.d("message", "error")
                    })
                queue.add(stringRequest)

        }
    }

    fun delet(id:Int,cn: Context){
        btnBorrar.setOnClickListener{
            val queue = Volley.newRequestQueue(cn)
            val sr: StringRequest = object : StringRequest(
                Method.DELETE, "https://proyectodecimo-sn96l.ondigitalocean.app/api/actividades/"+id,
                Response.Listener { response ->
                    Log.d("message", response)
                },
                Response.ErrorListener { error ->
                    Log.d("message", "error $error")
                }) {
            }
            queue.add(sr)
            val intent = Intent(cn, ApiMenu::class.java)
            startActivity(cn,intent,null)
        }
    }



}