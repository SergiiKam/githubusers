package com.example.githubusers.screens.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentUserDetailsBinding
import com.example.githubusers.screens.activity.baseFragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding>() {

    private val viewModel: UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setBinding(FragmentUserDetailsBinding.inflate(layoutInflater, container, false))

        return getBinding().apply {

            launchWhenStarted()

            viewModelShowUserDetails()

        }.root
    }

    private fun FragmentUserDetailsBinding.launchWhenStarted() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getUserDetailsFromRoom().collectLatest {

                detailsEmail.text = String.format(
                    view.resources.getString(R.string.user_details_email),
                    it.email
                )
                detailsDateCreate.text = String.format(
                    requireContext().getString(R.string.user_details_date_creation),
                    it.created_at
                )
                detailsName.text = String.format(
                    view.resources.getString(R.string.user_details_login),
                    it.name
                )
                detailsOrganization.text = String.format(
                    view.resources.getString(R.string.user_details_organization),
                    it.company
                )
                detailsFollowing.text = String.format(
                    view.resources.getString(R.string.user_details_following),
                    it.following.toString()
                )
                detailsFollowers.text = String.format(
                    view.resources.getString(R.string.user_details_followers),
                    it.followers?.toString()
                )

                Glide
                    .with(root.context)
                    .load(it.avatar_url)
                    .centerCrop()
                    .into(getBinding().image)
            }
        }
    }

    private fun viewModelShowUserDetails() {
        viewModel.updateUserDetails()
    }
}