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
import timber.log.Timber

@AndroidEntryPoint
class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding>() {

    private val viewModel : UserDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setBinding(FragmentUserDetailsBinding.inflate(layoutInflater, container, false))

        return getBinding().apply {

            launchWhenStarted()

            viewModelShowUserDetails()

        }.root
    }

    private fun FragmentUserDetailsBinding.launchWhenStarted() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getUserDetailsFromRoom().collectLatest {

                detailsEmail.text        = String.format(view?.resources?.getString(R.string.user_details_email)!!, it?.email?.toString())
                detailsDateCreate.text   = String.format(view?.resources?.getString(R.string.user_details_date_creation)!!, it?.created_at?.toString())
                detailsName.text         = String.format(view?.resources?.getString(R.string.user_details_login)!!, it?.name?.toString())
                detailsOrganization.text = String.format(view?.resources?.getString(R.string.user_details_organization)!!, it?.company?.toString())
                detailsFollowing.text    = String.format(view?.resources?.getString(R.string.user_details_following)!!, it?.following.toString())
                detailsFollowers.text    = String.format(view?.resources?.getString(R.string.user_details_followers)!!,  it?.followers?.toString())

                Glide
                    .with(root.context)
                    .load(it?.avatar_url?.toString())
                    .centerCrop()
                    .into(getBinding().image)
            }
        }
    }

    private fun viewModelShowUserDetails() {
        viewModel.userId = arguments?.getInt("userId") as Int
        viewModel.updateUserDetails()
    }
}