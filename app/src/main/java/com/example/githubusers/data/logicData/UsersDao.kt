package com.example.githubusers.data.logicData

import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersDao @Inject constructor(private val dao: UserDao) {

    fun getAllUsers(): Flow<List<UsersItemEntity>> = dao.getAll()

    fun insertUserList(userList : UserList) = dao.insertList(userList)

    fun insertUserDetails(userDetailsEntity: UserDetailsEntity) = dao.insertUserDetails(userDetailsEntity)

    fun getUserDetails(id : Int) : Flow<UserDetailsEntity> = dao.getUserDetailInfo(id)

    fun getUserById(id: Int) : UsersItemEntity = dao.getUserById(id)

    fun getUsersList(minId : Int = 0, count : Int) : List<UsersItemEntity> = dao.getUserList(minId, count)

    fun getUsersList(minId: Int?, count : Int) : List<UsersItemEntity> {
        return if (minId == null) getUsersList(count = count)
        else getUsersList(minId, count)
    }
}