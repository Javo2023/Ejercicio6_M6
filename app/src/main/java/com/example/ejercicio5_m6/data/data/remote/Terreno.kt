package com.example.ejercicio5_m6.data.data.remote

import com.google.gson.annotations.SerializedName

//{"price":450000,"id":"424905","type":"buy","img_src":"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg

data class Terreno(
    val id: String,
    val price: Int,
    val type: String,
    val buy: String,
    @SerializedName("img_src") val img: String  //@SerializedName permite usar otro nombre entregandole el de la api
)
