package com.example.githubusers.data.logicData

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.githubusers.data.api.RetrofitInstance
import com.example.githubusers.data.repository.RepInterface
import com.example.githubusers.model.UserList
import timber.log.Timber

class LogicDataRetrofit {

    suspend fun getAllUsers(): UserList {

        return RetrofitInstance.api.getListUsers()

    }

}