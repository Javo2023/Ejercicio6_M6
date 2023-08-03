package com.example.ejercicio5_m6.data.data

import com.example.ejercicio5_m6.remote.Terreno
import com.example.ejercicio5_m6.remote.TerrenosAPI

class Repositorio (private val terrenosAPI: TerrenosAPI){

    suspend fun cargarTerreno(): List<Terreno>{
        val respuesta = terrenosAPI.getData()

        if (respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let{
                return it
            }

        }
        return emptyList()

    }

  
}