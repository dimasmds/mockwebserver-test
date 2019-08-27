package com.riotfallen.mockwebservertest.data.network

import com.riotfallen.mockwebservertest.BuildConfig
import com.riotfallen.mockwebservertest.data.model.MovieResponse
import com.riotfallen.mockwebservertest.data.model.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("tv/popular")
    fun getTvPopular(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1
    ): Call<TvResponse>

    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1
    ): Call<MovieResponse>
}