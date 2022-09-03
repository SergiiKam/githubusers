package com.example.githubusers.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class UsersItemEntity(
    val avatar_url: String?,
    val events_url: String?,
    val followers_url: String?,
    val following_url: String?,
    val gists_url: String?,
    val gravatar_id: String?,
    val html_url: String?,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val login: String,
    val node_id: String?,
    val organizations_url: String?,
    val received_events_url: String?,
    val repos_url: String?,
    val site_admin: Boolean,
    val starred_url: String?,
    val subscriptions_url: String?,
    val type: String?,
    val url: String?
) : Parcelable