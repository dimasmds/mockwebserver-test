package com.riotfallen.mockwebservertest.ui.tv

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riotfallen.mockwebservertest.data.model.TvResponse
import com.riotfallen.mockwebservertest.data.repository.MovieRepository
import com.riotfallen.mockwebservertest.data.repository.ResponseCallback
import com.riotfallen.mockwebservertest.utils.State

class TvViewModel(private val repository: MovieRepository) : ViewModel() {

    val state: MutableLiveData<State> = MutableLiveData()
    val tvShows: MutableLiveData<List<TvResponse.Tv>> = MutableLiveData()

    fun getGetAllTv() {
        state.value = State.LOADING
        repository.getAllTvShows(object : ResponseCallback<TvResponse> {
            override fun onDataLoaded(data: TvResponse?) {
                state.value = State.LOADED
                tvShows.value = data?.results
            }

            override fun onError(message: String?) {
                state.value = State.ERROR
                d("ERROR!", message)
            }

        })
    }
}