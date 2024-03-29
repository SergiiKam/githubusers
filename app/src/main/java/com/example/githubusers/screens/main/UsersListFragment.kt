package com.example.githubusers.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentUsersListBinding
import com.example.githubusers.screens.activity.baseFragment.BaseFragment
import com.example.githubusers.screens.activity.baseFragment.ReplaceFragmentParameters
import com.example.githubusers.screens.activity.UserDetailsFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@AndroidEntryPoint
class UsersListFragment : BaseFragment<FragmentUsersListBinding>() {

    private val viewModel : UsersListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_users_list, container, false)

        setBinding(FragmentUsersListBinding.bind(view))

        return getBinding().apply {

            val adapter = UsersAdapter(::onAdapterClick)
            recView.adapter = adapter

            Timber.d("onCreateView")

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {

                viewModel.getRepositoryFlow().collectLatest(adapter::submitData)

                viewModel.misStateFlow.collectLatest {
                    Snackbar.make(getBinding().root, it, Snackbar.LENGTH_LONG).show()
                }
            }
        }.root
    }

    private fun onAdapterClick(bundle : Bundle){
        val userDetails = UserDetailsFragment()
        userDetails.arguments = bundle

        replaceFragment(ReplaceFragmentParameters(userDetails, R.id.frameUsersList))
    }

}


