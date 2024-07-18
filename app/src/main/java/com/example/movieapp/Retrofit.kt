package com.example.movieapp


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieDataService{
    @GET(ENDPOINT)
    fun fetchMovies(): Call<List<Movie>>
}

val api by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieDataService::class.java)
}