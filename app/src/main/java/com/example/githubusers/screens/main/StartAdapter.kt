package com.example.githubusers.screens.main

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubusers.R
import com.example.githubusers.databinding.ItemUserLayoutBinding
import com.example.githubusers.model.UserList
import retrofit2.Response

abstract class ItemUserViewHolder(val binding: ItemUserLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemUserLayoutBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false))
    )
}

class StartAdapter() : RecyclerView.Adapter<StartAdapter.ViewHold>() {

    class ViewHold(parent: ViewGroup) : ItemUserViewHolder(parent)

    private var userList : UserList = UserList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        return ViewHold(parent)
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {

        Log.d("debug", position.toString())

        holder.binding.user.text = userList[position].login

        Glide
            .with(holder.itemView)
            .load(userList[position].avatar_url)
            .centerCrop()
            .into(holder.binding.ivImage)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: UserList) {

        userList = list

        notifyDataSetChanged()
    }
}
