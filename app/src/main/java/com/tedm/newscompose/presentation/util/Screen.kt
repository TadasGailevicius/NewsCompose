package com.tedm.newscompose.presentation.util

sealed class Screen (val route: String) {
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")
    object HistoryScreen : Screen("history_screen")
}