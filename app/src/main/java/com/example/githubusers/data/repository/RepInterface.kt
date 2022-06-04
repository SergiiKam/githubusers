package com.example.githubusers.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem

interface RepInterface {
    suspend fun getAllUsers() : MutableLiveData<UserList>
}