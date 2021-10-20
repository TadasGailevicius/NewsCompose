package com.tedm.newscompose.repository

import com.tedm.newscompose.domain.local.entities.HistoryItem
import com.tedm.newscompose.domain.models.WeatherModel
import com.tedm.newscompose.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun insertHistoryItem(weatherModel: WeatherModel?)

    suspend fun getWeatherInfo(cityName: String): Resource<WeatherModel>

    fun list(): Flow<List<HistoryItem>>
}