package com.example.githubusers.data.repository

import androidx.lifecycle.LiveData
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getAllUsers() : Flow<List<UsersItemEntity>>
    suspend fun updateListApi()

    suspend fun getUserDetail(usersItemEntity: UsersItemEntity) : UserDetailsEntity
}

