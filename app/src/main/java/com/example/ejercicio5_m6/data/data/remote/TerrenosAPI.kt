package com.example.ejercicio5_m6.data.data.remote


import com.example.ejercicio5_m6.data.data.remote.Terreno
import retrofit2.Response
import retrofit2.http.GET

interface TerrenosAPI {

    @GET("realestate")
    suspend fun getData(): Response<List<Terreno>>

}