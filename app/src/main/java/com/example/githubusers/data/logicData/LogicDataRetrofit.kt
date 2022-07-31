package com.example.githubusers.data.logicData

import com.example.githubusers.data.api.RetrofitInstance
import com.example.githubusers.model.UserList

class LogicDataRetrofit {

    suspend fun getAllUsers(): UserList {

        return RetrofitInstance.api.getListUsers()

    }

}