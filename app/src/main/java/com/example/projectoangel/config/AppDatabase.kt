package com.example.projectoangel.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projectoangel.dao.HorariosDao
import com.example.projectoangel.models.Horario

@Database(entities=[Horario::class], version=1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun horarioDao(): HorariosDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}