package com.example.githubusers.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubusers.hilt.di.DataModule
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem
import dagger.Binds
import dagger.Module
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

interface RepInterface {
    suspend fun getAllUsers() : LiveData<List<UsersItem>>
}

