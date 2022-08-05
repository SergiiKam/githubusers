package com.example.githubusers.data.api

import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getListUsers(): UserList

    @GET("users/{username}")
    suspend fun getUserDetail(@Path("username") name: String) : UserDetailsEntity

}