package com.example.githubusers.data.repository

import androidx.lifecycle.LiveData
import com.example.githubusers.data.logicData.LogicDataRetrofit
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem
import javax.inject.Inject

class Repository @Inject constructor(
    private val logicDataRoom : LogicDataRoom
    ) : RepInterface  {

    override suspend fun updateListApi() {

        val logicDataRetrofit : LogicDataRetrofit = LogicDataRetrofit()
        val userList : UserList = logicDataRetrofit.getAllUsers()

        logicDataRoom.insertUserList(userList)
    }

    override fun getAllUsers(): LiveData<List<UsersItem>> {
        return logicDataRoom.getAllUsers()
    }


}