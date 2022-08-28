package com.example.githubusers.data.repository

import androidx.lifecycle.LiveData
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow

interface UsersRepositoryInterface {
    fun getAllUsers() : Flow<List<UsersItemEntity>>
    suspend fun updateListApi()

    suspend fun getUserDetailApi(usersItemEntity: UsersItemEntity) : UserDetailsEntity

    suspend fun updateUserDetailsById(id : Int)
    fun getUserDetailsRoom(id : Int) : Flow<UserDetailsEntity>
}

