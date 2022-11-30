package com.example.githubusers.screens.main

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubusers.data.repository.Source
import com.example.githubusers.data.repository.UsersRepositoryInterface
import com.example.githubusers.model.UsersItemEntity
import com.example.githubusers.screens.ViewModelBase.ViewModelBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class StartViewModel @Inject constructor(
    private val repository: UsersRepositoryInterface,
    private val source: Source
) : ViewModelBase() {

    val flow: Flow<PagingData<UsersItemEntity>> = Pager(
        PagingConfig(pageSize = 40), initialKey = 0
    ) {
        source
    }.flow

}