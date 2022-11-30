package com.example.projectoangel

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.projectoangel.databinding.ActivityMenuBinding
import com.example.projectoangel.menuApi.ApiMenu


class Menu : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedpreferences: SharedPreferences = getSharedPreferences("MyPref", 0)

        val editor: SharedPreferences.Editor = sharedpreferences.edit()
        //var id = sharedpreferences.getString("id", "")

        binding.CerrarSesion.setOnClickListener{
            editor.clear().apply();
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

        binding.ApiLocal.setOnClickListener{
            val intent = Intent(this,MenuApi::class.java)
            startActivity(intent)
        }

        binding.Perfil.setOnClickListener{
            val intent = Intent(this,Perfil::class.java)
            startActivity(intent)
        }

        binding.InfoApp.setOnClickListener{
            val intent = Intent(this,Info::class.java)
            startActivity(intent)
        }

        binding.ApiInternet.setOnClickListener{
            val intent = Intent(this, ApiMenu::class.java)
            startActivity(intent)
        }
    }
}