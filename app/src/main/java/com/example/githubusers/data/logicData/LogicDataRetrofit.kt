package com.example.githubusers.data.logicData

import com.example.githubusers.data.api.RetrofitInstance
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity

class LogicDataRetrofit {

    suspend fun getAllUsers(): UserList {

        return RetrofitInstance.api.getListUsers()

    }

    suspend fun getUserDetails(user : UsersItemEntity) : UserDetailsEntity {

        return RetrofitInstance.api.getUserDetail(user.login)
    }

}