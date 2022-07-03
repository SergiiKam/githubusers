package com.example.githubusers.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FragmentMain : Fragment() {

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

        adapter = StartAdapter()

        recyclerView.adapter = adapter

        Timber.d("onCreateView")

//        viewModel.userList.observe(viewLifecycleOwner) {
//
//            Timber.d(viewModel.userList.value?.size.toString())
//
//            adapter.setList(it)
//        }

        viewModel.onReady.observe(viewLifecycleOwner) {
            onReady()
        }

        return binding.root
    }

    fun onReady() {
        viewModel.userList.observe(viewLifecycleOwner) {

            Timber.d(viewModel.userList.value?.size.toString())

            adapter.setList(it)
        }
    }

}