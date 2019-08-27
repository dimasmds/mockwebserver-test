package com.riotfallen.mockwebservertest.data.network

import com.riotfallen.mockwebservertest.BuildConfig
import com.riotfallen.mockwebservertest.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("search/movie")
    fun searchMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1,
        @Query("query") query: String
    ) : Call<MovieResponse>

    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1
    ): Call<MovieResponse>
}