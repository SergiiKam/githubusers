package com.example.githubusers.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubusers.data.api.UsersApi
import com.example.githubusers.data.logicData.UsersDao
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val usersDao: UsersDao,
    private val usersApi: UsersApi,
    private val usersPagingSource : UsersPagingSource
) : UsersRepositoryInterface {

    private val flow: Flow<PagingData<UsersItemEntity>> = Pager(
        PagingConfig(pageSize = 40), initialKey = 0
    ) {
        usersPagingSource
    }.flow

    override fun getPagingFlow() : Flow<PagingData<UsersItemEntity>> = flow

    override suspend fun updateListApi() {

        val userList: UserList = usersApi.getListUsers()

        usersDao.insertUserList(userList)

    }

    override fun getAllUsers(): Flow<List<UsersItemEntity>> = usersDao.getAllUsers()

    override suspend fun getUserDetailApi(usersItemEntity: UsersItemEntity): UserDetailsEntity =
        usersApi.getUserDetail(usersItemEntity.login)

    override suspend fun updateUserDetailsById(id: Int) {

        val user = usersDao.getUserById(id)
        val userDetailsEntity = getUserDetailApi(user)

        Timber.d(userDetailsEntity.toString())

        usersDao.insertUserDetails(userDetailsEntity)

    }

    override fun getUserDetailsRoom(id: Int): Flow<UserDetailsEntity> =
        usersDao.getUserDetails(id)
}

