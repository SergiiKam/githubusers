package com.example.githubusers.data.logicData

import com.example.githubusers.data.api.RetrofitInstance
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import timber.log.Timber

class LogicDataRetrofit {

    suspend fun getAllUsers(): UserList {

        return RetrofitInstance.api.getListUsers()

    }

    suspend fun getUserDetails(user : UsersItemEntity) : UserDetailsEntity {

        Timber.d("start")
        val response = RetrofitInstance.api.getUserDetail(user.login)

        Timber.d(response.toString())

        return  response
    }

}