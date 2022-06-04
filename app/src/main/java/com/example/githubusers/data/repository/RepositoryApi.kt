package com.example.githubusers.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.githubusers.data.api.RetrofitInstance
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem
import retrofit2.Response

class RepositoryApi : RepInterface {

    var UserList : MutableLiveData<UserList> = MutableLiveData()

    override suspend fun getAllUsers() : MutableLiveData<UserList> {

        val report = RetrofitInstance.api.getListUsers()

        UserList.value = report.body()

        return UserList

    }

}