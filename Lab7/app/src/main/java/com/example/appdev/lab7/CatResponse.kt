package com.example.appdev.lab7


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CatResponse (
    @Json(name = "id")
    val id: String,
    @Json(name = "url")
    val image: String
)