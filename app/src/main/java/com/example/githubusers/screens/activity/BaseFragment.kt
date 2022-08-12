package com.example.githubusers.screens.activity

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment <T: ViewBinding> : Fragment() {

    private var bind : T ?= null

    fun getBinding() = bind!!
    fun setBinding(value : T) {
        bind = value
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}