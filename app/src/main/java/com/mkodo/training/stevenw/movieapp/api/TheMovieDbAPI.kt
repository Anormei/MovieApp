package com.mkodo.training.stevenw.movieapp.api

import com.mkodo.training.stevenw.movieapp.models.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDbAPI {

    val API_KEY: String
        get() = "0d3a65a3a761c4ac§768bb06458e32c20"

    @GET("movie/{id}?api_key=0d3a65a3a761c4ac§768bb06458e32c20&language=en-US")
    fun getMovie(@Path("id") id:String) : Call<List<Movie>>

    companion object{
        fun create() : TheMovieDbAPI {
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheMovieDbAPI::class.java)
        }
    }
}