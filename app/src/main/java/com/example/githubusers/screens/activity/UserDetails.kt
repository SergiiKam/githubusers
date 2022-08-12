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
class UserDetails : BaseFragment<FragmentUserDetailsBinding>() {

    private val viewModel : UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setBinding(FragmentUserDetailsBinding.inflate(layoutInflater, container, false))

        return getBinding().apply {

            viewModel.user = arguments?.getSerializable("usersItem") as UsersItemEntity
            viewModel.userDetails.observe(viewLifecycleOwner) {

                getBinding().detailsEmail.text          = "email: ${viewModel.userDetails.value?.email}"
                getBinding().detailsDateCreate.text     = "Creation date: ${viewModel.userDetails.value?.created_at.toString()}"
                getBinding().detailsName.text           = "Login: ${viewModel.userDetails.value?.name}"
                getBinding().detailsOrganization.text   = "Organization: ${viewModel.userDetails.value?.company}"
                getBinding().detailsFollowing.text      = "Following: ${viewModel.userDetails.value?.following.toString()}"
                getBinding().detailsFollowers.text      = "Followers: ${viewModel.userDetails.value?.followers.toString()}"

                Glide
                    .with(getBinding().root.context)
                    .load(viewModel.user.avatar_url)
                    .centerCrop()
                    .into(getBinding().image)
            }

            viewModel.getUserDetail()

        }.root
    }
}