package com.tedm.newscompose.repository

import com.tedm.newscompose.domain.remote.WeatherApi
import com.tedm.newscompose.domain.remote.responses.WeatherResponse
import com.tedm.newscompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class WeatherRepository @Inject constructor (
    private val api: WeatherApi
) {
    suspend fun getWeatherInfo(cityName: String): Resource<WeatherResponse> {
        val response = try {
            api.getWeatherInfo(cityName = cityName)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

}