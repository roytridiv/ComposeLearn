package com.example.composelearn.networkPojo


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesBodyRespItem(
    @Json(name = "category")
    val category: String,
    @Json(name = "desc")
    val desc: String,
    @Json(name = "imageUrl")
    val imageUrl: String,
    @Json(name = "name")
    val name: String
)