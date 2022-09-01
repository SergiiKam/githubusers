package com.example.githubusers.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatar_url)
        parcel.writeString(events_url)
        parcel.writeString(followers_url)
        parcel.writeString(following_url)
        parcel.writeString(gists_url)
        parcel.writeString(gravatar_id)
        parcel.writeString(html_url)
        parcel.writeInt(id)
        parcel.writeString(login)
        parcel.writeString(node_id)
        parcel.writeString(organizations_url)
        parcel.writeString(received_events_url)
        parcel.writeString(repos_url)
        parcel.writeByte(if (site_admin) 1 else 0)
        parcel.writeString(starred_url)
        parcel.writeString(subscriptions_url)
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsersItemEntity> {
        override fun createFromParcel(parcel: Parcel): UsersItemEntity {
            return UsersItemEntity(parcel)
        }

        override fun newArray(size: Int): Array<UsersItemEntity?> {
            return arrayOfNulls(size)
        }
    }
}