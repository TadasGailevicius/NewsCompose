package com.tedm.newscompose.presentation.util

sealed class Screen (val route: String) {
    object SplashScreen : Screen("splash_screen")
}