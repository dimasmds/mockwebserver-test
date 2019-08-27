package com.riotfallen.mockwebservertest.di

import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

object MovieCatalogue {
    private val listModule = mutableListOf<Module>().apply {
        add(repositoryModule)
        add(networkModule)
        add(viewModelModule)
    }

    fun init() = loadKoinModules(listModule)
}