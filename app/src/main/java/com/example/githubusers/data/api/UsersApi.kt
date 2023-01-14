package com.example.githubusers.data.api

import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersApi {

    @GET("users?")
    suspend fun getListUsers(@Query("per_page") per_page : Int = 100, @Query("since") since : Int = 0): UserList

    @GET("users/{username}")
    suspend fun getUserDetail(@Path("username") name: String) : UserDetailsEntity

}