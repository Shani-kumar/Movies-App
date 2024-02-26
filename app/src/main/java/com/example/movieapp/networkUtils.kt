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
    val poster:String,

    @SerializedName("Plot")
    val plot: String,

    @SerializedName("Year")
    val year : String,

    @SerializedName("Runtime")
    val runtime : String,

    @SerializedName("Language")
    val languages:String,

    @SerializedName("imdbRating")
    val imdbRating:String



)