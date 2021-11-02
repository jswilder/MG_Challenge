package com.jwilder.tinder.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseModel(
    val data: List<Gif>
)

@JsonClass(generateAdapter = true)
data class Gif(
    val type: String,
    val id: String,
    val url: String,
    @Json(name = "bitly_url")
    val bitlyUrl: String,
    val rating: String,
    val title: String
)