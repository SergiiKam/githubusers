package com.example.githubusers.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubusers.data.api.ApiService
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class PagingSource @Inject constructor(
    private val logicDataRoom : LogicDataRoom,
    private val retrofitApiService : ApiService
): PagingSource<Int, UsersItemEntity>() {

    override fun getRefreshKey(state: PagingState<Int, UsersItemEntity>): Int {

        Timber.d("state.pages.last().data.last().id: ${state.pages.last().data.last().id}")

        return state.pages.last().data.last().id
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UsersItemEntity> {

        val perPage = params.loadSize

        var userList: List<UsersItemEntity>

        withContext(Dispatchers.IO) {

            userList = logicDataRoom.getUsersList(params.key ?: 1, perPage)

            if (userList.size < perPage) {
                val usersPage = retrofitApiService.getListUsers(perPage, params.key ?: 1)
                logicDataRoom.insertUserList(usersPage)

                userList = logicDataRoom.getUsersList(params.key ?: 1, perPage)
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