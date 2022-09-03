package com.example.githubusers.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class UserDetailsEntity(
    @ColumnInfo(name = "login")
    val login: String,
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    @ColumnInfo()
    val node_id : String?,
    @ColumnInfo()
    val avatar_url : String?,
    @ColumnInfo()
    val gravatar_id : String?,
    @ColumnInfo()
    val url: String?,
    @ColumnInfo()
    val html_url : String?,
    @ColumnInfo()
    val followers_url : String?,
    @ColumnInfo()
    val following_url : String?,
    @ColumnInfo()
    val gists_url : String?,
    @ColumnInfo()
    val starred_url : String?,
    @ColumnInfo()
    val subscriptions_url : String?,
    @ColumnInfo()
    val organizations_url : String?,
    @ColumnInfo()
    val repos_url : String?,
    @ColumnInfo()
    val events_url : String?,
    @ColumnInfo()
    val received_events_url : String?,
    @ColumnInfo()
    val type : String?,
    @ColumnInfo()
    val site_admin: Boolean?,
    @ColumnInfo()
    val name: String?,
    @ColumnInfo()
    val company: String?,
    @ColumnInfo()
    val blog : String?,
    @ColumnInfo()
    val location : String?,
    @ColumnInfo()
    val email : String?,
    @ColumnInfo()
    val hireable : String?,
    @ColumnInfo()
    val bio : String?,
    @ColumnInfo()
    val twitter_username : String?,
    @ColumnInfo()
    val public_repos : Int?,
    @ColumnInfo()
    val public_gists : Int?,
    @ColumnInfo()
    val followers : Int?,
    @ColumnInfo()
    val following : Int?,
    @ColumnInfo()
    val created_at : String?,
    @ColumnInfo()
    val updated_at : String?
) : Parcelable