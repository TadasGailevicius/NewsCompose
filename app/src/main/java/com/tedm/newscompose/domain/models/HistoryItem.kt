package com.tedm.newscompose.domain.models

data class HistoryItem(
    val description: String,
    val temp: Double,
    val tempMax: Double,
    val dt: Int,
    val name: String
)
