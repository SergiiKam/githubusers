package com.example.githubusers.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UsersItemEntity

@Database(entities = [UsersItemEntity::class, UserDetailsEntity::class], version = 2)
abstract class Dbase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

}