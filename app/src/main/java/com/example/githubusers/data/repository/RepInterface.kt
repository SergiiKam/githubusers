package com.example.githubusers.data.repository

import androidx.lifecycle.LiveData
import com.example.githubusers.model.UsersItemEntity

interface RepInterface {
    fun getAllUsers() : LiveData<List<UsersItemEntity>>
    suspend fun updateListApi()
}

