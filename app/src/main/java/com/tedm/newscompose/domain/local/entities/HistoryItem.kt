package com.tedm.newscompose.domain.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryItem(
    val description: String,
    val temp: Double,
    val tempMax: Double,
    val dt: Int,
    val name: String,
    val icon: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int
)
