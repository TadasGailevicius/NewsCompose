package com.tedm.newscompose.repository

import com.tedm.newscompose.domain.models.HistoryItem
import com.tedm.newscompose.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun insertHistoryItem(historyItem: HistoryItem?)

    suspend fun getWeatherInfo(cityName: String) : Resource<HistoryItem>

    fun list(): Flow<List<com.tedm.newscompose.domain.local.entities.HistoryItem>>
}