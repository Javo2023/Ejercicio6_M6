package com.example.ejercicio5_m6.Presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercicio5_m6.data.data.Repositorio
import com.example.ejercicio5_m6.data.data.remote.Terreno
import com.example.ejercicio5_m6.data.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM (application: Application): AndroidViewModel(application){
    private val repositorio:Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        repositorio = Repositorio(api)
    }

    fun getListaTerrenos() = viewModelScope.launch{
        terrenosLiveData.value = repositorio.cargarTerreno()
    }
}