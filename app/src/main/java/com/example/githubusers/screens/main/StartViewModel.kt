package com.example.githubusers.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.RepInterface
import com.example.githubusers.data.repository.RepositoryApi
import com.example.githubusers.model.UserList
import kotlinx.coroutines.launch

class StartViewModel : ViewModel() {

    val repository : RepInterface = RepositoryApi()
    var UserList : MutableLiveData<UserList> = MutableLiveData()

    fun getUserList() {
        viewModelScope.launch {
            UserList = repository.getAllUsers()
        }
    }
}