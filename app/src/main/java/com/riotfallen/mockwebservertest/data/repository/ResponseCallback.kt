package com.riotfallen.mockwebservertest.data.repository

interface ResponseCallback<T> {
    fun onDataLoaded(data: T?)
    fun onError(message: String?)
}