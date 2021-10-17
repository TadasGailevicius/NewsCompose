package com.tedm.newscompose.repository

import com.tedm.newscompose.domain.models.HistoryItem
import com.tedm.newscompose.domain.remote.responses.WeatherResponse
import com.tedm.newscompose.util.Resource

interface WeatherRepository {

    suspend fun getWeatherInfo(cityName: String) : Resource<HistoryItem>
}