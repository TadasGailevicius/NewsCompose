package com.tedm.newscompose.util

sealed class UiEvent {
    data class ShowSnackbar(val uiText: UiText) : UiEvent()
}