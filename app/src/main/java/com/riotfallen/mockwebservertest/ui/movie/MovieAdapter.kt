package com.riotfallen.mockwebservertest.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riotfallen.mockwebservertest.BuildConfig
import com.riotfallen.mockwebservertest.R
import com.riotfallen.mockwebservertest.data.model.MovieResponse
import com.squareup.picasso.Picasso

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movies: List<MovieResponse.Movie> = listOf()

    fun setMovies(movies: List<MovieResponse.Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(movies[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var titleTextView: TextView = itemView.findViewById(R.id.rimTextViewTitle)
        private var descTextView: TextView = itemView.findViewById(R.id.rimTexTViewDesc)
        private var imageView: ImageView = itemView.findViewById(R.id.rimImageViewThumbnail)

        fun bindItem(movie: MovieResponse.Movie) {
            titleTextView.text = movie.title
            descTextView.text = movie.overview
            Picasso.get().load(BuildConfig.IMAGE_BASE_URL + movie.backdropPath).fit().centerCrop().into(imageView)
        }
    }
}