package com.mkodo.training.stevenw.movieapp.screens.movie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.mkodo.training.stevenw.movieapp.R

class TrendingAdapter(private val callback: TrendingCallback, private val dataSet: Array<String?>) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button

        init{
            button = itemView.findViewById(R.id.movie_button)
            button.setOnClickListener{
                callback.showMovie()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

}