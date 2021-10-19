package com.tedm.newscompose.domain.use_case

import com.tedm.newscompose.domain.models.WeatherModel
import com.tedm.newscompose.repository.WeatherRepository
import com.tedm.newscompose.util.Resource

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(cityName: String): Resource<WeatherModel> {
        return repository.getWeatherInfo(cityName = cityName)
    }
}