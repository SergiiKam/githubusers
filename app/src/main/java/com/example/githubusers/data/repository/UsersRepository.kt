package com.example.githubusers.data.repository

import com.example.githubusers.data.api.RetrofitInstance
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.*
import timber.log.Timber

import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val logicDataRoom : LogicDataRoom
    ) : UsersRepositoryInterface  {

    override suspend fun updateListApi() {

        val userList : UserList = RetrofitInstance.api.getListUsers()

        logicDataRoom.insertUserList(userList)
    }

    override fun getAllUsers(): Flow<List<UsersItemEntity>>
            = logicDataRoom.getAllUsers()

    override suspend fun getUserDetailApi(usersItemEntity: UsersItemEntity): UserDetailsEntity
            = RetrofitInstance.api.getUserDetail(usersItemEntity.login!!)

    override suspend fun updateUserDetailsById(id : Int) {

        val user = logicDataRoom.getUserById(id)
        val userDetailsEntity = getUserDetailApi(user)

        Timber.d(userDetailsEntity.toString())

        logicDataRoom.insertUserDetails(userDetailsEntity)

    }

    override fun getUserDetailsRoom(id : Int) : Flow<UserDetailsEntity>
    = logicDataRoom.getUserDetails(id)
}