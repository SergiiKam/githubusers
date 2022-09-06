package com.example.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.githubusers.databinding.ActivityMainBinding
import com.example.githubusers.screens.main.UsersListFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, UsersListFragment())
            .commit()

        //setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController : NavController = findNavController(R.id.fragmentContainerView)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}