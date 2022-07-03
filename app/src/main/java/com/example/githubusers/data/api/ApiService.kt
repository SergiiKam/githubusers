package com.example.githubusers.data.api

import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getListUsers(): UserList
}