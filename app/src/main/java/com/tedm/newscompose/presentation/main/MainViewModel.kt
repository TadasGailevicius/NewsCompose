package com.tedm.newscompose.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) :ViewModel(){

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    fun setUsernameText(username: String) {
        _usernameText.value = username
    }

    fun setIsUsernameError(error: String) {
        _usernameError.value = error
    }

}