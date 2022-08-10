package com.example.githubusers.screens.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentUserDetailsBinding
import com.example.githubusers.model.UsersItemEntity
import com.example.githubusers.screens.main.UsersListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetails : Fragment() {

    private lateinit var binding: FragmentUserDetailsBinding

    private val viewModel : UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserDetailsBinding.inflate(layoutInflater, container, false)

        return binding.apply {

            viewModel.user = arguments?.getSerializable("usersItem") as UsersItemEntity
            viewModel.userDetails.observe(viewLifecycleOwner) {

                binding.detailsEmail.text       = viewModel.userDetails.value?.html_url
                binding.detailsDateCreate.text  = viewModel.userDetails.value?.id.toString()
                binding.detailsName.text        = viewModel.userDetails.value?.login
                binding.detailsOrganization.text = viewModel.userDetails.value?.company
                binding.detailsFollowing.text = viewModel.userDetails.value?.following.toString()
                binding.detailsFollowers.text = viewModel.userDetails.value?.followers.toString()

                Glide
                    .with(binding.root.context)
                    .load(viewModel.user.avatar_url)
                    .centerCrop()
                    .into(binding.image)
            }

            viewModel.getUserDetail()

        }.root
    }
}