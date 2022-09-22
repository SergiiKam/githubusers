package com.example.githubusers.screens.activity

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.UsersRepositoryInterface
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.screens.ViewModelBase.ViewModelBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: UsersRepositoryInterface,
    private val savedState: SavedStateHandle
) : ViewModelBase() {

    private val args = UserDetailsFragmentArgs.fromSavedStateHandle(savedState)

    fun getUserDetailsFromRoom(): Flow<UserDetailsEntity> =
        repository.getUserDetailsRoom(args.userId)

    fun updateUserDetails() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {

            repository.updateUserDetailsById(args.userId)

        }
    }
}