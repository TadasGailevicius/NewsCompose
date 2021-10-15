package com.tedm.newscompose.domain.models

data class HistoryItem(
    val description: String,
    val temp: Int,
    val tempMax: Double,
    val dt: Int,
    val name: String
)
