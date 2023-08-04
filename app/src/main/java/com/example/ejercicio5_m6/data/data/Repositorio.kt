package com.example.ejercicio5_m6.data.data

import androidx.lifecycle.LiveData
import com.example.ejercicio5_m6.data.data.local.TerrenoDao
import com.example.ejercicio5_m6.data.data.local.TerrenoEntity
import com.example.ejercicio5_m6.data.data.remote.Terreno
import com.example.ejercicio5_m6.data.data.remote.TerrenosAPI
import org.w3c.dom.Entity

class Repositorio (private val terrenosAPI: TerrenosAPI, private val terrenoDao: TerrenoDao){

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()

    suspend fun cargarTerreno(){
        val respuesta = terrenosAPI.getData()


        if (respuesta.isSuccessful){
            val resp  = respuesta.body()
            resp?.let{terrenos ->
                val terrenosEntity = terrenos.map{it.transformar() }
                terrenoDao.insertarTerrenos(terrenosEntity)

            }
        }
    }
}
fun Terreno.transformar(): TerrenoEntity = TerrenoEntity(this.id,this.price,this.type,this.img)
