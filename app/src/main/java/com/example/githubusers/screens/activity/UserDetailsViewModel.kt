package com.example.githubusers.screens.activity

import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.UsersRepositoryInterface
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.screens.ViewModelBase.ViewModelBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: UsersRepositoryInterface
) : ViewModelBase() {

    var userId: Int = 0

    fun getUserDetailsFromRoom(): Flow<UserDetailsEntity> =
        repository.getUserDetailsRoom(userId).filterNotNull()

    fun updateUserDetails() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            repository.updateUserDetailsById(userId)
        }
    }
}