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
    @ColumnInfo(name = "node_id")
    val node_id : String?,
    @ColumnInfo(name = "avatar_url")
    val avatar_url : String?,
    @ColumnInfo(name = "gravatar_id")
    val gravatar_id : String?,
    @ColumnInfo(name = "url")
    val url: String?,
    @ColumnInfo(name = "html_url")
    val html_url : String?,
    @ColumnInfo(name = "followers_url")
    val followers_url : String?,
    @ColumnInfo(name = "following_url")
    val following_url : String?,
    @ColumnInfo(name = "gists_url")
    val gists_url : String?,
    @ColumnInfo(name = "starred_url")
    val starred_url : String?,
    @ColumnInfo(name = "subscriptions_url")
    val subscriptions_url : String?,
    @ColumnInfo(name = "organizations_url")
    val organizations_url : String?,
    @ColumnInfo(name = "repos_url")
    val repos_url : String?,
    @ColumnInfo(name = "events_url")
    val events_url : String?,
    @ColumnInfo(name = "received_events_url")
    val received_events_url : String?,
    @ColumnInfo(name = "type")
    val type : String?,
    @ColumnInfo(name = "site_admin")
    val site_admin: Boolean?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "company")
    val company: String?,
    @ColumnInfo(name = "blog")
    val blog : String?,
    @ColumnInfo(name = "location")
    val location : String?,
    @ColumnInfo(name = "email")
    val email : String?,
    @ColumnInfo(name = "hireable")
    val hireable : String?,
    @ColumnInfo(name = "bio")
    val bio : String?,
    @ColumnInfo(name = "twitter_username")
    val twitter_username : String?,
    @ColumnInfo(name = "public_repos")
    val public_repos : Int?,
    @ColumnInfo(name = "public_gists")
    val public_gists : Int?,
    @ColumnInfo(name = "followers")
    val followers : Int?,
    @ColumnInfo(name = "following")
    val following : Int?,
    @ColumnInfo(name = "created_at")
    val created_at : String?,
    @ColumnInfo(name = "updated_at")
    val updated_at : String?
) : Parcelable