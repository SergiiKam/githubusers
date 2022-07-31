package com.example.githubusers.data.api

import com.example.githubusers.model.UserList
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getListUsers(): UserList
}