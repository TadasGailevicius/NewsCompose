package com.tedm.newscompose.domain.remote.responses

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)