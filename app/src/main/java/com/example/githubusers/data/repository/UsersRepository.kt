package com.example.githubusers.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubusers.data.api.ApiService
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val logicDataRoom: LogicDataRoom,
    private val api: ApiService,
    private val pagingSource : PagingSource
) : UsersRepositoryInterface {

    private val flow: Flow<PagingData<UsersItemEntity>> = Pager(
        PagingConfig(pageSize = 40), initialKey = 0
    ) {
        pagingSource
    }.flow

    override fun getPagingFlow() : Flow<PagingData<UsersItemEntity>> = flow

    override suspend fun updateListApi() {

        val userList: UserList = api.getListUsers()

        logicDataRoom.insertUserList(userList)

    }

    override fun getAllUsers(): Flow<List<UsersItemEntity>> = logicDataRoom.getAllUsers()

    override suspend fun getUserDetailApi(usersItemEntity: UsersItemEntity): UserDetailsEntity =
        api.getUserDetail(usersItemEntity.login!!)

    override suspend fun updateUserDetailsById(id: Int) {

        val user = logicDataRoom.getUserById(id)
        val userDetailsEntity = getUserDetailApi(user)

        Timber.d(userDetailsEntity.toString())

        logicDataRoom.insertUserDetails(userDetailsEntity)

    }

    override fun getUserDetailsRoom(id: Int): Flow<UserDetailsEntity> =
        logicDataRoom.getUserDetails(id)
}

