package com.example.githubusers.data.repository

import android.util.Log
import com.example.githubusers.data.api.RetrofitInstance
import com.example.githubusers.model.UserList
import retrofit2.Response

class Repository {
    suspend fun getUsers() : Response<UserList> {
        Log.d("debug", "Repository 1.1")

        val report = RetrofitInstance.api.getListUsers()

        Log.d("debug", "Repository 1.2")

        return report
    }
}