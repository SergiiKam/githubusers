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

//    companion object {
//        private var database : Dbase ?= null
//
//        @Synchronized
//        fun getInstance(context: Context) : Dbase {
//
//            if (database == null) {
//                database = Room.databaseBuilder(context, Dbase::class.java, "database").build()
//            }
//
//            return database as Dbase
//        }
//    }
}