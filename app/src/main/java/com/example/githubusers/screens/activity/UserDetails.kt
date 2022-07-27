package com.example.githubusers.screens.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentUserDetailsBinding
import com.example.githubusers.model.UsersItem
import com.example.githubusers.screens.main.FragmentMain

class UserDetails : Fragment() {

    private lateinit var binding: FragmentUserDetailsBinding
    private lateinit var usersItem: UsersItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserDetailsBinding.inflate(layoutInflater, container, false)

        usersItem = arguments?.getSerializable("usersItem") as UsersItem

        Glide
            .with(this)
            .load(usersItem.avatar_url)
            .centerCrop()
            .into(binding.image)

        binding.detailsEmail.text = usersItem.html_url
        binding.detailsDateCreate.text = usersItem.id.toString()
        binding.detailsName.text = usersItem.login

        binding.buttonBack.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout_main_activity, FragmentMain())
                .commit()
        }

        return binding.root
    }
}