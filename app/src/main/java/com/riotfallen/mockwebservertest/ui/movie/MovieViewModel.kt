package com.riotfallen.mockwebservertest.ui.movie

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riotfallen.mockwebservertest.data.model.MovieResponse
import com.riotfallen.mockwebservertest.data.repository.MovieRepository
import com.riotfallen.mockwebservertest.data.repository.ResponseCallback
import com.riotfallen.mockwebservertest.utils.State

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    val state: MutableLiveData<State> = MutableLiveData()
    val movies: MutableLiveData<List<MovieResponse.Movie>> = MutableLiveData()

    fun getAllMovies() {
        state.value = State.LOADING
        repository.getAllMovies(object : ResponseCallback<MovieResponse> {
            override fun onDataLoaded(data: MovieResponse?) {
                state.value = State.LOADED
                movies.value = data?.results
            }

            override fun onError(message: String?) {
                state.value = State.ERROR
                d("ERROR!", message)
            }

        })
    }
}