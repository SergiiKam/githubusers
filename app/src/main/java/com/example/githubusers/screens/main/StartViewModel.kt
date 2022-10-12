package com.example.githubusers.screens.main

import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.UsersRepositoryInterface
import com.example.githubusers.model.UsersItemEntity
import com.example.githubusers.screens.ViewModelBase.ViewModelBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StartViewModel @Inject constructor(
    private val repository: UsersRepositoryInterface
) : ViewModelBase() {

    init {
        updateUsersList()
    }

    fun updateUsersList() {
        viewModelScope.launch(Dispatchers.IO) { repository.updateListApi() }
    }

    fun getUsers(): Flow<List<UsersItemEntity>> = repository.getAllUsers()
}