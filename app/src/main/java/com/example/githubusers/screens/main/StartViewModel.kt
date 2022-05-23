package com.example.githubusers.screens.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.Repository
import com.example.githubusers.model.UserList
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel : ViewModel() {

    val repository : Repository = Repository()
    var UserList : MutableLiveData<Response<UserList>> = MutableLiveData()

    fun getUserList() {
        viewModelScope.launch {
            UserList.value = repository.getUsers()
        }
    }
}