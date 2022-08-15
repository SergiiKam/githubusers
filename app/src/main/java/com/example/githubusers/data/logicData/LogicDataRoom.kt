package com.example.githubusers.data.logicData

import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow

class LogicDataRoom(var dao: UserDao) {

    fun getAllUsers(): Flow<List<UsersItemEntity>> {

        return dao.getAll()

    }

    fun insertUserList(userList : UserList) {

        userList.forEach { it ->

            dao.insert(it)

        }
    }

    fun insertUserDetails(userDetailsEntity: UserDetailsEntity) {
        dao.insertUserDetails(userDetailsEntity)
    }

    fun getUserDetails(id : Int) : Flow<UserDetailsEntity> {
        return dao.getUserDetailInfo(id)
    }

    fun getUserById(id: Int) : UsersItemEntity {
        return dao.getUserById(id)
    }
}