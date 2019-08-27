package com.riotfallen.mockwebservertest.data.repository

import com.riotfallen.mockwebservertest.data.model.MovieResponse
import com.riotfallen.mockwebservertest.data.model.TvResponse
import com.riotfallen.mockwebservertest.data.network.Services
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(private val services: Services) {

    fun getAllMovies(callback: ResponseCallback<MovieResponse>) {
        services.getMoviePopular().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                callback.onDataLoaded(response.body())
            }

        })
    }

    fun getAllTvShows(callback: ResponseCallback<TvResponse>) {
        services.getTvPopular().enqueue(object : Callback<TvResponse> {
            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                callback.onDataLoaded(response.body())
            }

        })
    }
}