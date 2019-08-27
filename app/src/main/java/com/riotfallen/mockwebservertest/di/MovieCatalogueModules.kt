package com.riotfallen.mockwebservertest.di

import com.riotfallen.mockwebservertest.data.network.Client
import com.riotfallen.mockwebservertest.data.network.Services
import com.riotfallen.mockwebservertest.data.repository.MovieRepository
import com.riotfallen.mockwebservertest.ui.movie.MovieViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.TimeUnit


val repositoryModule = module {
    factory { MovieRepository(get()) }
}


val networkModule = module {
    single { services }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
}

private fun getOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().apply {
        retryOnConnectionFailure(true)
        connectTimeout(15, TimeUnit.SECONDS)
        readTimeout(15, TimeUnit.SECONDS)
        writeTimeout(15, TimeUnit.SECONDS)
    }.build()
}

private val services: Services = Client.getClient(getOkHttpClient()).create(Services::class.java)