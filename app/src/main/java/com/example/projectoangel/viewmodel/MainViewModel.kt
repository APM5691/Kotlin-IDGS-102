package com.example.projectoangel.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectoangel.models.Horario
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val horariosList = MutableLiveData<List<Horario>>()
    var busqueda = MutableLiveData<String>()

    fun iniciar(){
        viewModelScope.launch{
             //horariosList.value = withContext(Dispatchers.IO) {
                // db.horarioDao().insert( arrayListOf<Horario>(
                //     Horario(ID = 0, IDUsuario = 2)
                // ))

               //  db.horarioDao().getAll()
            // }
                 for (horario in horariosList.value!!) {
                     Log.d("mensaje", "id ${horario.ID}, id usuario ${horario.IDUsuario}")
                 }
        }
    }
}