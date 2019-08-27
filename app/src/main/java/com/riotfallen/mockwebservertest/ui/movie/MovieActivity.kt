package com.riotfallen.mockwebservertest.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.riotfallen.mockwebservertest.R
import com.riotfallen.mockwebservertest.data.model.MovieResponse
import com.riotfallen.mockwebservertest.utils.State
import com.riotfallen.mockwebservertest.utils.invisible
import com.riotfallen.mockwebservertest.utils.visible
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModel()

    private val adapter: MovieAdapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        movieViewModel.getAllMovies()
        movieViewModel.state.observe(this, stateObserver)
        movieViewModel.movies.observe(this, movieObserver)

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    movieViewModel.searchMovie(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    movieViewModel.searchMovie(newText)
                }
                return true
            }
        })
    }

    private val movieObserver = Observer<List<MovieResponse.Movie>?> {
        if (it != null) {
            adapter.setMovies(it)
        }
    }

    private val stateObserver = Observer<State> {
        when (it) {
            State.LOADING -> {
                recyclerView.invisible()
                progressBar.visible()
            }
            State.LOADED -> {
                progressBar.invisible()
                recyclerView.visible()
            }
            State.ERROR -> {
                progressBar.invisible()
                recyclerView.invisible()
            }
        }
    }
}
