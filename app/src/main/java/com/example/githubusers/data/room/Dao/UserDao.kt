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
    fun Insert(usersItem: UsersItem)

    @Update
    fun Update(usersItem: UsersItem)

    @Delete
    fun Delete(usersItem: UsersItem)


    @Query("select * from UsersItem")
    fun getAll() : MutableLiveData<UserList>

    @Query("select * from UsersItem where id = :id")
    fun getUserById(id : Int)
}