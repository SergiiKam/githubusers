package com.example.githubusers.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.githubusers.data.room.Dao.UserDao
import com.example.githubusers.model.UsersItem

@Database(entities = [UsersItem::class], version = 1)
abstract class Dbase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

}