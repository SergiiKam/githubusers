package com.example.githubusers.screens.main

import com.example.githubusers.data.repository.UsersRepositoryInterface
import com.example.githubusers.screens.ViewModelBase.ViewModelBase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val repository: UsersRepositoryInterface
) : ViewModelBase() {

    fun getRepositoryFlow() = repository.getPagingFlow()

}