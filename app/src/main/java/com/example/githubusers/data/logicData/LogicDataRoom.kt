package com.example.githubusers.data.logicData

import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class LogicDataRoom @Inject constructor(private val dao: UserDao) {

    fun getAllUsers(): Flow<List<UsersItemEntity>> = dao.getAll()

    fun insertUserList(userList: UserList) = dao.insertListUsersItemEntity(userList)

    fun insertUserDetails(userDetailsEntity: UserDetailsEntity) = dao
        .insertUserDetails(userDetailsEntity)

    fun getUserDetails(id: Int): Flow<UserDetailsEntity> = dao.getUserDetailInfo(id).filterNotNull()

    fun getUserById(id: Int): UsersItemEntity = dao.getUserById(id)
}