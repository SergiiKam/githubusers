package com.example.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubusers.databinding.ActivityMainBinding
import com.example.githubusers.screens.main.UsersListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main_activity, UsersListFragment())
            .commit()

    }
}