package com.example.githubusers.data.logicData

import com.example.githubusers.data.room.Dao.UserDao
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
}