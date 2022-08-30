package com.example.githubusers.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.githubusers.data.api.ApiService
import com.example.githubusers.data.logicData.LogicDataRoom
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.data.room.Dbase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    fun provideRetrofit() : ApiService {
        val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api : ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }

        return api
    }
}
