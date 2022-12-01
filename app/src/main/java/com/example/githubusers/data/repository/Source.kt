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

class Source @Inject constructor(
    private val logicDataRoom : LogicDataRoom,
    private val api : ApiService
): PagingSource<Int, UsersItemEntity>() {

    override fun getRefreshKey(state: PagingState<Int, UsersItemEntity>): Int {

        Timber.d("state.pages.last().data.last().id: ${state.pages.last().data.last().id}")

        return state.pages.last().data.last().id
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UsersItemEntity> {

        val perPage = params.loadSize

        var userList: List<UsersItemEntity>?

        withContext(Dispatchers.IO) {

            userList = logicDataRoom.getUsersList(params.key ?: 1, perPage)

            if (userList!!.size < perPage) {
                val usersPage = api.getListUsers(perPage, params.key ?: 1)
                logicDataRoom.insertUserList(usersPage)

                userList = logicDataRoom.getUsersList(params.key ?: 1, perPage)
            }
        }

        val prevKeyPage: Int? =
            if (params.key == 0) {
                null
            } else {
                params.key
            }

        val nextKeyPage: Int? = if (userList!!.isNotEmpty())
            userList!!.last().id + 1
        else
            null

        return LoadResult.Page(userList!!, prevKeyPage, nextKeyPage)
    }

}