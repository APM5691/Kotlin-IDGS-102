package com.example.projectoangel.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projectoangel.dao.TareasDao
import com.example.projectoangel.dao.UsuariosDao
import com.example.projectoangel.models.Tarea
import com.example.projectoangel.models.Usuario

@Database(entities=[Tarea::class,Usuario::class], version=1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tareas(): TareasDao
    abstract fun usuarios(): UsuariosDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            var tempInstance = INSTANCE

            if (tempInstance != null) return  tempInstance

            synchronized(this) {
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).allowMainThreadQueries().build()

                INSTANCE = instance

                return instance
            }
        }
    }

}