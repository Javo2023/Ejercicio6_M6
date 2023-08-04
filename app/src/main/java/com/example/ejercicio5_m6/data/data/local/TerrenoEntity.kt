package com.example.ejercicio5_m6.data.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tabla_terrenos")
data class TerrenoEntity(
    @PrimaryKey val id: String,
    val precio: Int,
    val tipo: String,
    val imagen: String
)

