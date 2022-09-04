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
class UsersListViewModel @Inject constructor(
    private val repository: UsersRepositoryInterface
) : ViewModelBase() {

    init {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            repository.updateListApi()
        }
    }

    fun getUsers(): Flow<List<UsersItemEntity>> = repository.getAllUsers()
}