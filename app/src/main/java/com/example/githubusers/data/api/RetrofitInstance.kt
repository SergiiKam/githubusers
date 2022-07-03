package com.example.githubusers.data.api

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import timber.log.Timber

object RetrofitInstance {
    private val retrofit by lazy {

        Log.d("debug", "retrofit by lazy'")

        //Timber.d("RetrofitInstance 'retrofit by lazy'")

        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : ApiService by lazy {

        //Timber.d("RetrofitInstance 'ApiService by lazy'")
        Log.d("debug", "'ApiService by lazy'")


        //Log.d("debug", "retrofit 1.2")
        retrofit.create(ApiService::class.java)
    }
}