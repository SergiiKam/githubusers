package com.example.githubusers.data.room.Dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import androidx.room.Dao
import com.example.githubusers.model.UserList
import com.example.githubusers.model.UsersItem

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(usersItem: UsersItem)

    @Update
    fun update(usersItem: UsersItem)

    @Delete
    fun delete(usersItem: UsersItem)

    @Query("select * from UsersItem")
    fun getAll() : LiveData<List<UsersItem>>

    @Query("select * from UsersItem")
    fun getAllUsers() : List<UsersItem>

    @Query("select * from UsersItem where id = :id")
    fun getUserById(id : Int) : UsersItem
}