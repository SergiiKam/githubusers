package com.example.githubusers.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentMainBinding
import com.example.githubusers.screens.activity.UserDetails
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class UsersListFragment : Fragment() {

    private val viewModel : StartViewModel by viewModels()

    lateinit var binding: FragmentMainBinding
    lateinit var adapter: StartAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        binding = FragmentMainBinding.bind(view)

        recyclerView = binding.recView

        adapter = StartAdapter(::onAdapterClick)

        recyclerView.adapter = adapter

        Timber.d("onCreateView")

        viewModel.onReady.observe(viewLifecycleOwner) {
            onReady()
        }

        return binding.root
    }

    private fun onReady() {
        viewModel.userList.observe(viewLifecycleOwner) {

            Timber.d(viewModel.userList.value?.size.toString())

            adapter.submitList(it)
        }
    }

    private fun onAdapterClick(bundle : Bundle){
        val userDetails : UserDetails = UserDetails()
        userDetails.arguments = bundle

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main_activity, userDetails)
            .commit()
    }
}