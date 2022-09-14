package com.example.githubusers.screens.activity.baseFragment

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment<T : ViewBinding> : Fragment() {

    private var bind: T? = null

    fun getBinding() = bind!!
    fun setBinding(value: T) {
        bind = value
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }

    fun replaceFragment(parameters: ReplaceFragmentParameters) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(parameters.containerViewId, parameters.fragment)
            .addToBackStack(null)
            .commit()
    }
}