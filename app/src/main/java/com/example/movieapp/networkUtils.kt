package com.example.movieapp


import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("Title")
    val title: String,

    @SerializedName("Released")
    val releaseDate: String,

    @SerializedName("Genre")
    val genre: String,

    @SerializedName("Poster")
    val poster:String
)