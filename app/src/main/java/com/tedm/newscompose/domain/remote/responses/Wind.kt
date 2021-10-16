package com.tedm.newscompose.domain.remote.responses

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)