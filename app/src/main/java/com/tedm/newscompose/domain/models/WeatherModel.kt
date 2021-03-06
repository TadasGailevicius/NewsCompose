package com.tedm.newscompose.domain.models

data class WeatherModel(
    val description: String,
    val temp: Double,
    val tempMin: Double,
    val tempMax: Double,
    val dt: Int,
    val name: String,
    val icon: String
)
