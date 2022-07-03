package com.example.githubusers.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusers.data.repository.RepInterface
import com.example.githubusers.model.UsersItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StartViewModel @Inject constructor(
    private val repository: RepInterface
) : ViewModel() {

    var userList : LiveData<List<UsersItem>> = MutableLiveData()

    init {
        getUserList()
    }

    private fun getUserList() {
        viewModelScope.launch(Dispatchers.IO) {
            userList = repository.getAllUsers()
        }
    }

}