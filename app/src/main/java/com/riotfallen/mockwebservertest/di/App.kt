package com.riotfallen.mockwebservertest.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

private val loadFeature by lazy { MovieCatalogue.init() }
private fun injectFeature() = loadFeature

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@App) }
        injectFeature()
    }
}