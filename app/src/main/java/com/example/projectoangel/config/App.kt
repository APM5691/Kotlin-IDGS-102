package com.example.projectoangel.config

import android.app.Application
import androidx.room.Room

class App:Application() {
    companion object{
        lateinit var db:AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this, AppDatabase::class.java,
            "db"
        ).build()
    }

}