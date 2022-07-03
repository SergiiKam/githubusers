package com.example.githubusers.data.logicData

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem
import timber.log.Timber

class LogicDataRoom(var dao: UserDao) {

    suspend fun getAllUsers(): LiveData<List<UsersItem>> {


        Timber.d("LogicDataRoom 'getAllUsers'")
        Log.d("debug", "LogicDataRoom 'getAllUsers'")

        val allUsers = dao.getAll()

        val test = dao.getAllUsers()

        Log.d("debug", "LogicDataRoom 'getAllUsers' ${allUsers.value?.size}")

        Log.d("debug", "-----")
        Log.d("debug", "LogicDataRoom 'getAllUsers' -> ${test?.size}")
        Log.d("debug", "-----")

        return allUsers
    }

    suspend fun insertUserList(userList : UserList) {

        Timber.d("LogicDataRoom 'insertUserList'")
        Log.d("debug", "LogicDataRoom 'insertUserList', userList.size ${userList.size}")

        userList.forEach { it ->

            Log.d("debug", "LogicDataRoom 'insertUserList' -> ${it.id}")

            dao.insert(it)
        }
    }
}