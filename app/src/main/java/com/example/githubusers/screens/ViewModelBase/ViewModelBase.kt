package com.example.githubusers.screens.ViewModelBase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber


open class ViewModelBase : ViewModel() {

    val misStateFlow = MutableStateFlow("")

    protected val coroutineExceptionHandler = CoroutineExceptionHandler{
            _, throwable ->

        throwable.printStackTrace()

        viewModelScope.launch(Dispatchers.IO) {
            misStateFlow.emit("Exception")
        }

        Timber.d("Exception")
    }

}