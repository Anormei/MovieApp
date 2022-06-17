package com.mkodo.training.stevenw.movieapp.screens.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mkodo.training.stevenw.movieapp.R
import com.mkodo.training.stevenw.movieapp.api.TheMovieDbAPI
import com.mkodo.training.stevenw.movieapp.databinding.FragmentMovieBinding
import com.mkodo.training.stevenw.movieapp.models.Movie
import com.mkodo.training.stevenw.movieapp.screens.movie.adapters.TrendingAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieBinding.inflate(inflater, container, false)

        val api = TheMovieDbAPI.create().getMovie("666243")

        api.enqueue(object: Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {

                if(response?.body() != null){
                    binding.movieTitle.text = response.body()!![0].title
                    Log.i("MovieFragment", "Changing movie title")
                }

                Log.i("MovieFragment", "Call Successful!")

            }

            override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
                Log.d("MovieFragment", "Failed Call: ${t.toString()}")
            }
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}