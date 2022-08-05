package com.example.githubusers.hilt.di

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.data.repository.UsersRepository
import com.example.githubusers.data.repository.Repository
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.data.room.Dbase
import com.example.githubusers.model.UserList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideInstance(@ApplicationContext context: Context): Dbase {
        return Room.databaseBuilder(context, Dbase::class.java, "database")
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(logicDataRoom: LogicDataRoom) : UsersRepository {
        return Repository(logicDataRoom)
    }

    @Provides
    fun provideUserList() : MutableLiveData<UserList> {
        return MutableLiveData()
    }

    @Provides
    fun provideLogicDataRoom(dao: UserDao) : LogicDataRoom{
        return LogicDataRoom(dao)
    }

    @Provides
    fun provideUserDao(dbase : Dbase) : UserDao {
        return  dbase.getUserDao()
    }

}