package com.example.githubusers.screens.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.UsersRepository
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UsersItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    lateinit var user: UsersItemEntity
    lateinit var userDetails : MutableLiveData<UserDetailsEntity>

init {
    userDetails = MutableLiveData<UserDetailsEntity>()
}

    private val coroutineExceptionHandler = CoroutineExceptionHandler{
            _, throwable ->
        throwable.printStackTrace()

        Timber.d("Exception")
    }

    fun getUserDetail() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            userDetails.postValue(repository.getUserDetail(user))
        }
    }

}