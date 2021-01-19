package com.example.appdev.lab7


import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("v1/images/search?size=full&limit=100")
    fun getCats() : Call<List<CatResponse>>
}