package com.example.githubusers.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UsersItemEntity

@Database(entities = [UsersItemEntity::class], version = 1)
abstract class Dbase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

}