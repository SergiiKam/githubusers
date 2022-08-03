package com.example.githubusers.screens.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubusers.R
import com.example.githubusers.databinding.ItemUserLayoutBinding
import com.example.githubusers.model.UsersItemEntity
import okhttp3.internal.notify


abstract class ItemUserViewHolder(val binding: ItemUserLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemUserLayoutBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false))
    )
}

class StartAdapter(var callBack: (Bundle) -> Unit) : ListAdapter<UsersItemEntity,StartAdapter.ViewHold>(UserListDiffCallBack()) {

    class ViewHold(parent: ViewGroup) : ItemUserViewHolder(parent)

    //private var userList : List<UsersItemEntity> = emptyList()

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
                linearLayoutOnClick(position)
            }
        }

    }

//    override fun getItemCount(): Int {
//        return userList.size
//    }

//    fun setList(list: List<UsersItemEntity>) {
//
//        userList = list
//
//        userList.forEach {
//            notifyItemInserted(it.id)
//        }
//
//        //notifyDataSetChanged()
//    }

    private fun linearLayoutOnClick(position : Int) {
        val bundle = Bundle()
        bundle.putSerializable("usersItem", getItem(position))

        callBack(bundle)
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

