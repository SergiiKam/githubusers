package com.example.githubusers.data.room.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.githubusers.model.UsersItemEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(usersItem: UsersItemEntity)

    @Update
    fun update(usersItem: UsersItemEntity)

    @Delete
    fun delete(usersItem: UsersItemEntity)

    @Query("select * from UsersItemEntity")
    fun getAll() : LiveData<List<UsersItemEntity>>

    @Query("select * from UsersItemEntity")
    fun getAllUsers() : List<UsersItemEntity>

    @Query("select * from UsersItemEntity where id = :id")
    fun getUserById(id : Int) : UsersItemEntity
}