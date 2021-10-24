package com.tedm.newscompose.domain.remote

import com.tedm.newscompose.BuildConfig
import com.tedm.newscompose.domain.remote.responses.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun getWeatherInfo(
        @Query("q")
        cityName: String,
        @Query("appid")
        apiKey: String = BuildConfig.API_KEY
    ): WeatherResponse
}