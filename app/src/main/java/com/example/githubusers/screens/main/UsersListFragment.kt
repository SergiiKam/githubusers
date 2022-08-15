package com.example.githubusers.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentMainBinding
import com.example.githubusers.screens.activity.BaseFragment
import com.example.githubusers.screens.activity.UserDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@AndroidEntryPoint
class UsersListFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel : StartViewModel by viewModels()
    lateinit var adapter: StartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        setBinding(FragmentMainBinding.bind(view))

        adapter = StartAdapter(::onAdapterClick)

        getBinding().recView.adapter = adapter

        Timber.d("onCreateView")

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getUsers().collectLatest {
                adapter.submitList(it)
            }
        }

        return getBinding().root
    }

    private fun onAdapterClick(bundle : Bundle){
        val userDetails : UserDetails = UserDetails()
        userDetails.arguments = bundle

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main_activity, userDetails)
            .addToBackStack(null)
            .commit()
    }

}


