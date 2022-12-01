package com.example.githubusers.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentMainBinding
import com.example.githubusers.screens.activity.baseFragment.BaseFragment
import com.example.githubusers.screens.activity.baseFragment.ReplaceFragmentParameters
import com.example.githubusers.screens.activity.UserDetailsFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@AndroidEntryPoint
class UsersListFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel : StartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        setBinding(FragmentMainBinding.bind(view))

        return getBinding().apply {

            val adapter = StartAdapter(::onAdapterClick)
            recView.adapter = adapter

            Timber.d("onCreateView")

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {

                viewModel.flow.collectLatest(adapter::submitData)

                viewModel.misStateFlow.collectLatest {
                    Snackbar.make(getBinding().root, it, Snackbar.LENGTH_LONG).show()
                }
            }
        }.root
    }

    private fun onAdapterClick(bundle : Bundle){
        val userDetails = UserDetailsFragment()
        userDetails.arguments = bundle

        replaceFragment(ReplaceFragmentParameters(userDetails, R.id.frame_layout_main_activity))
    }

}


