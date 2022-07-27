package com.example.githubusers.screens.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubusers.R
import com.example.githubusers.databinding.ItemUserLayoutBinding
import com.example.githubusers.model.UsersItem
import com.example.githubusers.screens.activity.UserDetails
import timber.log.Timber

abstract class ItemUserViewHolder(val binding: ItemUserLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemUserLayoutBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false))
    )
}

class StartAdapter(var callBack: (Bundle) -> Unit) : RecyclerView.Adapter<StartAdapter.ViewHold>() {

    class ViewHold(parent: ViewGroup) : ItemUserViewHolder(parent)

    private var userList : List<UsersItem> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        return ViewHold(parent)
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {

        holder.binding.userName.text = "name - ${userList[position].login}"

        holder.binding.userId.text = "id - ${userList[position].id.toString()}"

        Glide
            .with(holder.itemView)
            .load(userList[position].avatar_url)
            .centerCrop()
            .into(holder.binding.ivImage)

        holder.binding.linearItemLayout.setOnClickListener {
            linearLayoutOnClick(position)
        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<UsersItem>) {

        userList = list

        notifyDataSetChanged()
    }

    private fun linearLayoutOnClick(position : Int) {
        val bundle = Bundle()
        bundle.putSerializable("usersItem", userList[position])

        callBack(bundle)
    }
}
