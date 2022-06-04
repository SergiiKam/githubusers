package com.example.githubusers.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UserList

class RepositoryDao(var dao: UserDao) : RepInterface {

    //val userList : UserList = UserList()

    override suspend fun getAllUsers(): MutableLiveData<UserList> {
        return dao.getAll()
    }
}