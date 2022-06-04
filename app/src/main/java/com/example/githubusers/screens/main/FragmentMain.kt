package com.example.githubusers.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.databinding.FragmentMainBinding

class FragmentMain : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var viewModel: StartViewModel
    lateinit var adapter: StartAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        binding = FragmentMainBinding.bind(view)
        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        viewModel.getUserList()

        recyclerView = binding.recView

        adapter = StartAdapter()

        recyclerView.adapter = adapter

        viewModel.UserList.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }

        return binding.root
    }

}