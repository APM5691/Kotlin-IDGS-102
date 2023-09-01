package com.example.projectoangel

import android.Manifest
import android.content.ContentUris
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectoangel.adapter.ImageAdapter
import com.example.projectoangel.databinding.ActivityMainBinding


class Main : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        imageAdapter = ImageAdapter(this, emptyArray())

    }

    override fun onStart() {
        super.onStart()

        pedirPermisos()

        val listImages = loadImages()

        imageAdapter = ImageAdapter(this, listImages.toTypedArray())

        recyclerView.adapter = imageAdapter
    }

    private fun pedirPermisos() {
        // Pedir permisos
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // No hay permiso
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        } else {
            // Si hay permiso
            Toast.makeText(this, "Ya hay permiso", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadImages(): MutableList<Uri> {
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.DATA
        )

        val arrayOfImagesAndVideosExternal = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        val arrayOfImagesAndVideosInternal = contentResolver.query(
            MediaStore.Images.Media.INTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        val imagesList = mutableListOf<Uri>()

        if (arrayOfImagesAndVideosExternal != null) {
            while (arrayOfImagesAndVideosExternal.moveToNext()) {
                val id = arrayOfImagesAndVideosExternal.getLong(0)
                val name = arrayOfImagesAndVideosExternal.getString(1)
                val data = arrayOfImagesAndVideosExternal.getString(2)
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id
                )


                imagesList.add(contentUri)
            }
        }

        if (arrayOfImagesAndVideosInternal != null) {
            while (arrayOfImagesAndVideosInternal.moveToNext()) {
                val id = arrayOfImagesAndVideosInternal.getLong(0)
                val name = arrayOfImagesAndVideosInternal.getString(1)
                val data = arrayOfImagesAndVideosInternal.getString(2)
                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI,
                    id
                )

                imagesList.add(contentUri)
            }
        }

        return imagesList
    }
}