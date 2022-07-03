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
    //private lateinit var viewModel : StartViewModel


    lateinit var binding: FragmentMainBinding
    lateinit var adapter: StartAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        binding = FragmentMainBinding.bind(view)

        //viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        //viewModel.getUserList()

        recyclerView = binding.recView

        adapter = StartAdapter()

        recyclerView.adapter = adapter

        viewModel.userList.observe(viewLifecycleOwner) {

            Timber.d(viewModel.userList.value?.size.toString())

            adapter.setList(it)
        }

        return binding.root
    }

}