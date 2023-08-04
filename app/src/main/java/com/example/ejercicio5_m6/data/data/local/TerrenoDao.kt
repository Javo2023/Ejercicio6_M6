package com.example.ejercicio5_m6.data.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejercicio5_m6.data.data.remote.Terreno

@Dao
interface TerrenoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTerrenos (terrenosEntity: List<TerrenoEntity>)

    @Query("Select * from tabla_terrenos order by id asc")
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>
}