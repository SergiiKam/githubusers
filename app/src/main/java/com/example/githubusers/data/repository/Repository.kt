package com.example.githubusers.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubusers.data.logicData.LogicDataRetrofit
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem
import timber.log.Timber
import javax.inject.Inject

class Repository @Inject constructor(
    private val logicDataRoom : LogicDataRoom
    ) : RepInterface  {

    private suspend fun updateListApi() {

        val logicDataRetrofit : LogicDataRetrofit = LogicDataRetrofit()
        val userList : UserList = logicDataRetrofit.getAllUsers()

        Log.d("debug", "Repository updateListApi: ${userList.size}")

        logicDataRoom.insertUserList(userList)
        
    }

    override suspend fun getAllUsers(): LiveData<List<UsersItem>> {

        updateListApi()

        val users = logicDataRoom.getAllUsers()

        Log.d("debug", "Repository getAllUsers: ${users.value?.size}")

        return users
    }


}