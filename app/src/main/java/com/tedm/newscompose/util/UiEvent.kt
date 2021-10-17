package com.tedm.newscompose.util

sealed class UiEvent {
    data class ShowSnackbar(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
}