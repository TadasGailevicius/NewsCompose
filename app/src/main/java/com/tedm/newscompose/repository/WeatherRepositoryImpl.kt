package com.tedm.newscompose.repository

import com.tedm.newscompose.domain.remote.WeatherApi
import com.tedm.newscompose.util.Resource
import com.tedm.newscompose.util.UiText
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import com.tedm.newscompose.R
import com.tedm.newscompose.domain.models.HistoryItem

@ActivityScoped
class WeatherRepositoryImpl @Inject constructor (
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherInfo(cityName: String): Resource<HistoryItem> {
        val response = try {
            api.getWeatherInfo(cityName = cityName)
        } catch(e: Exception) {
            return Resource.Error(UiText.StringResource(R.string.error_unknown))
        }
        return Resource.Success(response.toHistoryItem())
    }

}