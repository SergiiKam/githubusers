package com.example.githubusers.screens.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.UsersRepository
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UsersItemEntity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    var userId : Int = 0

    private val coroutineExceptionHandler = CoroutineExceptionHandler{
            _, throwable ->
        throwable.printStackTrace()

        Timber.d("Exception")

        

    }

    fun getUserDetailsFromRoom() : Flow<UserDetailsEntity> {
        Timber.d(userId.toString())

        val flow = repository.getUserDetailsRoom(userId)

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            flow.collectLatest {
                Timber.d(it.toString())
            }
        }

        return flow
    }

    fun updateUserDetails() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            repository.updateUserDetailsById(userId)
        }
    }
}