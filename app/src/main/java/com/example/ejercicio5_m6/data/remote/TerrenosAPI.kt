package com.example.ejercicio5_m6.data.remote


import retrofit2.Response
import retrofit2.http.GET

interface TerrenosAPI {

    @GET("realestate")
    suspend fun getData(): Response<List<Terreno>>

}