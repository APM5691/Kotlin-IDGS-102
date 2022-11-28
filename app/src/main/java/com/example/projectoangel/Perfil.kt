package com.example.projectoangel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectoangel.databinding.ActivityPerfilBinding
import com.example.projectoangel.databinding.ActivityTareaMenuBinding

class Perfil : AppCompatActivity() {

    lateinit var binding : ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}