package com.example.ejercicio5_m6.data.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ejercicio5_m6.data.data.remote.Terreno

@Dao
interface TerrenoDao {

    @Insert
    suspend fun insertarTerreno (terrenoEntity: TerrenoEntity)

    @Query("Select * from tabla_terrenos order by id asc")
    fun obtenerTerrenos(): LiveData<List<Terreno>>
}