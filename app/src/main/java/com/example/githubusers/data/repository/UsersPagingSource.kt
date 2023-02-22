package com.example.githubusers.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubusers.data.api.UsersApi
import com.example.githubusers.data.logicData.UsersDao
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class UsersPagingSource @Inject constructor(
    private val usersDao : UsersDao,
    private val retrofitApiService : UsersApi
): PagingSource<Int, UsersItemEntity>() {

    override fun getRefreshKey(state: PagingState<Int, UsersItemEntity>): Int {

        Timber.d("state.pages.last().data.last().id: ${state.pages.last().data.last().id}")

        return state.pages.last().data.last().id
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UsersItemEntity> {

        val perPage = params.loadSize

        var userList: List<UsersItemEntity>

        withContext(Dispatchers.IO) {

            userList = usersDao.getUsersList(params.key,perPage)

            if (userList.size < perPage) {
                val usersPage = retrofitApiService.getListUsers(perPage, params.key ?: 1)
                usersDao.insertUserList(usersPage)

                userList = usersDao.getUsersList(params.key ?: 1, perPage)
            }
        }

        return LoadResult.Page(
            userList,
            params.key,
            if (userList.isNotEmpty())
                userList.last().id + 1
            else null
        )
    }

}