package com.example.githubusers.data.repository

import com.example.githubusers.data.logicData.LogicDataRetrofit
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class Repository @Inject constructor(
    private val logicDataRoom : LogicDataRoom
    ) : UsersRepository  {

    private val logicDataRetrofit : LogicDataRetrofit by lazy {
        LogicDataRetrofit()
    }

    override suspend fun updateListApi() {

        val userList : UserList = logicDataRetrofit.getAllUsers()

        logicDataRoom.insertUserList(userList)
    }

    override fun getAllUsers(): Flow<List<UsersItemEntity>> {
        return logicDataRoom.getAllUsers()
    }

    override suspend fun getUserDetail(usersItemEntity: UsersItemEntity): UserDetailsEntity {
        return logicDataRetrofit.getUserDetails(usersItemEntity)
    }

}