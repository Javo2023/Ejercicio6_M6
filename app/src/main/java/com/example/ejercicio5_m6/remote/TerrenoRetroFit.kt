package com.example.ejercicio5_m6.remote


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TerrenoRetroFit {
    companion object {
        private const val URL_BASE ="https://android-kotlin-fun-mars-server.appspot.com/"

        fun getRetrofitTerreno() : TerrenosAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)

                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(TerrenosAPI::class.java)
        }
    }
}