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
    val title: String,
    val images: Images
)

@JsonClass(generateAdapter = true)
data class Images(
    val original: Image?,
    @Json(name = "downsized_small")
    val downsizedSmall: Image?
)

@JsonClass(generateAdapter = true)
data class Image(
    val url: String?,
    val mp4: String?
)


/*
{
  "height": "292",
  "width": "480",
  "mp4_size": "139750",
  "mp4": "https://media4.giphy.com/media/3ibA9NgxKgeSEwffgh/giphy-downsized-small.mp4?cid=4293def3nokvxq1r5ariditv3okl2yik922t4j5cgjcv7wx1&rid=giphy-downsized-small.mp4&ct=g"
}
 */