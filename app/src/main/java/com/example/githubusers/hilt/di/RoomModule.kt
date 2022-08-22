package com.example.githubusers.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.data.room.Dbase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule::class])
class RoomModule {

    @Provides
    @Singleton
    fun provideInstance(@ApplicationContext context: Context): Dbase {
        return Room.databaseBuilder(context, Dbase::class.java, "database")
            .build()
    }

    @Provides
    fun provideUserDao(dbase : Dbase) : UserDao {
        return  dbase.getUserDao()
    }
}
