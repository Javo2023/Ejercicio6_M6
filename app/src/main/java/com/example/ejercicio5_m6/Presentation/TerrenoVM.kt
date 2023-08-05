package com.example.ejercicio5_m6.Presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercicio5_m6.data.data.Repositorio
import com.example.ejercicio5_m6.data.data.local.TerrenoDatabase
import com.example.ejercicio5_m6.data.data.remote.Terreno
import com.example.ejercicio5_m6.data.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM (application: Application): AndroidViewModel(application){
    private val repositorio:Repositorio
    fun terrenosLiveData() = repositorio.obtenerTerrenos()

    init {
        val terrenoApi = TerrenoRetroFit.getRetrofitTerreno()
        val terrenoBaseDato = TerrenoDatabase.getDataBase(application).getITerrenoDao()
        repositorio = Repositorio(terrenoApi,terrenoBaseDato)
    }

    fun getListaTerrenos() = viewModelScope.launch{
        repositorio.cargarTerreno()
    }

    fun terrenoLiveData(id:String) = repositorio.getTerreno(id)
}