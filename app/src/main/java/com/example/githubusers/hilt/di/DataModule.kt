package com.example.githubusers.hilt.di

import com.example.githubusers.data.repository.UsersRepository
import com.example.githubusers.data.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun provideRepository(repository: Repository) : UsersRepository

}