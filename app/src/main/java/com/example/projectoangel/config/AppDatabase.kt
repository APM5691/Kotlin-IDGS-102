package com.example.projectoangel.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projectoangel.dao.HorariosDao
import com.example.projectoangel.dao.TareasDao
import com.example.projectoangel.models.Horario
import com.example.projectoangel.models.Tarea
import kotlinx.coroutines.CoroutineScope

@Database(entities=[Horario::class,Tarea::class], version=1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun horarios(): HorariosDao
    abstract fun tareas(): TareasDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            var tempInstance = INSTANCE

            if (tempInstance != null)
            {
                return  tempInstance
            }

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