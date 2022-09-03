package com.example.githubusers.screens.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.githubusers.model.UsersItemEntity
import com.example.githubusers.screens.main.adapter.ItemUserViewHolder


class StartAdapter(var callBack: (Int) -> Unit) : ListAdapter<UsersItemEntity, StartAdapter.ViewHold>(UserListDiffCallBack()) {

    class ViewHold(parent: ViewGroup) : ItemUserViewHolder(parent)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHold {
        return ViewHold(parent)
    }

    override fun onBindViewHolder(holder: ViewHold, position: Int) {

        holder.binding.apply {

            val item = getItem(position)

            userName.text = item.login
            userId.text = item.id.toString()

            Glide
                .with(holder.itemView)
                .load(item.avatar_url)
                .centerCrop()
                .into(ivImage)

            linearItemLayout.setOnClickListener {
                linearLayoutOnclickId(position)
            }
        }
    }

    private fun linearLayoutOnclickId(position: Int) {

        callBack(getItem(position).id)
    }

    class UserListDiffCallBack : DiffUtil.ItemCallback<UsersItemEntity>() {
        override fun areItemsTheSame(oldItem: UsersItemEntity, newItem: UsersItemEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UsersItemEntity,
            newItem: UsersItemEntity
        ): Boolean {
            return oldItem == newItem
        }

    }

}

