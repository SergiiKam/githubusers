package com.example.githubusers.screens.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.databinding.ItemUserLayoutBinding

abstract class ItemUserViewHolder(val binding: ItemUserLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    constructor(parent: ViewGroup) : this(
        ItemUserLayoutBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false))
    )
}