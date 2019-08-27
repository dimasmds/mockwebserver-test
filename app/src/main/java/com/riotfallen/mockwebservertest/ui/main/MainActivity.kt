package com.riotfallen.mockwebservertest.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.Observer
import com.riotfallen.mockwebservertest.R
import com.riotfallen.mockwebservertest.ui.movie.MovieViewModel
import com.riotfallen.mockwebservertest.utils.State
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel.getAllMovies()
        movieViewModel.state.observe(this, Observer {
            when(it) {
                State.LOADING -> {
                    d("LOADING", "lalala")
                }
                State.LOADED -> {
                    d("LOADED", "bla bla")
                }
                State.ERROR -> {
                    d("ERROR", "adakwdak")
                }
            }
        })
    }
}
