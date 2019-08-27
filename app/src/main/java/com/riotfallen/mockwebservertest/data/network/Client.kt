package com.riotfallen.mockwebservertest.data.network

import com.riotfallen.mockwebservertest.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Client {
    fun getClient(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constant.baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
}