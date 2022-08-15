package com.example.githubusers.screens.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentUserDetailsBinding
import com.example.githubusers.model.UsersItemEntity
import com.example.githubusers.screens.main.UsersListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class UserDetails : BaseFragment<FragmentUserDetailsBinding>() {

    private val viewModel : UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setBinding(FragmentUserDetailsBinding.inflate(layoutInflater, container, false))

        return getBinding().apply {

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.getUserDetailsFromRoom().collectLatest {
                    getBinding().detailsEmail.text          = "email: ${it?.email}"
                    getBinding().detailsDateCreate.text     = "Creation date: ${it?.created_at.toString()}"
                    getBinding().detailsName.text           = "Login: ${it?.name}"
                    getBinding().detailsOrganization.text   = "Organization: ${it?.company}"
                    getBinding().detailsFollowing.text      = "Following: ${it?.following.toString()}"
                    getBinding().detailsFollowers.text      = "Followers: ${it?.followers.toString()}"

                    Glide
                        .with(getBinding().root.context)
                        .load(it?.avatar_url)
                        .centerCrop()
                        .into(getBinding().image)
                }
            }

            viewModel.userId = arguments?.getInt("userId") as Int
            viewModel.updateUserDetails()

        }.root
    }
}