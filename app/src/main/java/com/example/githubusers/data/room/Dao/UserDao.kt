package com.example.githubusers.data.room.Dao

import androidx.room.*
import androidx.room.Dao
import com.example.githubusers.model.UserDetailsEntity
import com.example.githubusers.model.UsersItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(usersItem: UsersItemEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(list: List<UsersItemEntity>)

    @Update
    fun update(usersItem: UsersItemEntity)

    @Delete
    fun delete(usersItem: UsersItemEntity)

    @Query("select MAX(id) from UsersItemEntity")
    fun getMaxId() : Int

    @Query("select * from UsersItemEntity")
    fun getAll() : Flow<List<UsersItemEntity>>

    @Query("select * from UsersItemEntity")
    fun getAllUsers() : List<UsersItemEntity>

    @Query("select * from UsersItemEntity where id = :id")
    fun getUserById(id : Int) : UsersItemEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUserDetails(userDetailsEntity: UserDetailsEntity)

    @Query("select * from UserDetailsEntity where id = :id")
    fun getUserDetailInfo(id: Int) : Flow<UserDetailsEntity>

    @Query("select * from UsersItemEntity where id >= :minId limit :count")
    fun  getUserList(minId: Int = 0, count:Int) : List<UsersItemEntity>
}