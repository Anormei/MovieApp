package com.mkodo.training.stevenw.movieapp

import com.mkodo.training.stevenw.movieapp.api.TheMovieDbAPI
import com.mkodo.training.stevenw.movieapp.models.Movie
import org.junit.Test
import org.junit.Assert.assertEquals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TheMovieDbAPIShould {

    @Test
    fun `return a movie title from id`() {

        val api = TheMovieDbAPI.create().getMovie("666243")
        var title: String? = ""
        api.enqueue(object : Callback<List<Movie>>{

            override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?){

                if(response?.body() != null){
                    val movies = response.body()
                    title = movies?.get(0)?.title
                    //assertEquals("The Witcher: Nightmare of the Wolf", title)
                    assertEquals(0, 1)
                }
            }

            override fun onFailure(call: Call<List<Movie>>?, t: Throwable?){

            }
        })



    }
}