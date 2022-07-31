package com.example.githubusers.data.logicData

import androidx.lifecycle.LiveData
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity

class LogicDataRoom(var dao: UserDao) {

    fun getAllUsers(): LiveData<List<UsersItemEntity>> {

        return dao.getAll()

    }

    fun insertUserList(userList : UserList) {

        userList.forEach { it ->

            dao.insert(it)

        }
    }
}