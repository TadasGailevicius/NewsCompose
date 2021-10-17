package com.tedm.newscompose.presentation.main

import com.tedm.newscompose.domain.models.HistoryItem

data class WeatherState(
    val historyItem: HistoryItem? = null,
    val isLoading: Boolean = false
)
