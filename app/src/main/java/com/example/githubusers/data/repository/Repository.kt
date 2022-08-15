package com.example.githubusers.data.repository

import com.example.githubusers.data.logicData.LogicDataRetrofit
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.*
import timber.log.Timber
import java.lang.Exception

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

    override suspend fun getUserDetailApi(usersItemEntity: UsersItemEntity): UserDetailsEntity {
        return logicDataRetrofit.getUserDetails(usersItemEntity)
    }

    override suspend fun updateUserDetailsById(id : Int) {

        val user = logicDataRoom.getUserById(id)
        val userDetailsEntity = getUserDetailApi(user)

        Timber.d(userDetailsEntity.toString())

        logicDataRoom.insertUserDetails(userDetailsEntity)

    }

    override fun getUserDetailsRoom(id : Int) : Flow<UserDetailsEntity> {
        return logicDataRoom.getUserDetails(id)
    }
}