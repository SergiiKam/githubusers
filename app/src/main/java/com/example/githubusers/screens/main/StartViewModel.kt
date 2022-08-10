package com.example.githubusers.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.UsersRepository
import com.example.githubusers.model.UsersItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class StartViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    var userList : MutableLiveData<List<UsersItemEntity>> = MutableLiveData()

    private val coroutineExceptionHandler = CoroutineExceptionHandler{
            _, throwable ->
        throwable.printStackTrace()
    }

    init {
        getUserList()
    }

    private fun getUserList() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {

            Timber.d("getUserList")

            repository.getAllUsers().collect() {
                userList.postValue(it)
            }

            repository.updateListApi()

            Timber.d("userList=$userList")

        }
    }

}