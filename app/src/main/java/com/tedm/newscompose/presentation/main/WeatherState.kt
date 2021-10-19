package com.tedm.newscompose.presentation.main

import com.tedm.newscompose.domain.models.WeatherModel

data class WeatherState(
    val weatherModel: WeatherModel? = null,
    val isLoading: Boolean = false,
)
