package com.example.projectoangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectoangel.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }
}