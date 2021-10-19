package com.tedm.newscompose.repository

import com.tedm.newscompose.domain.remote.WeatherApi
import com.tedm.newscompose.util.Resource
import com.tedm.newscompose.util.UiText
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import com.tedm.newscompose.R
import com.tedm.newscompose.domain.local.HistoryItemDao
import com.tedm.newscompose.domain.local.entities.HistoryItem
import com.tedm.newscompose.domain.models.WeatherModel
import kotlinx.coroutines.flow.Flow

@ActivityScoped
class WeatherRepositoryImpl @Inject constructor(
    private val dao: HistoryItemDao,
    private val api: WeatherApi
) : WeatherRepository {

    private suspend fun insertHistoryItemUnderLimit(weatherModel: WeatherModel, maxItem: Int) {
        val historyItem = HistoryItem(
            description = weatherModel.description,
            temp = weatherModel.temp,
            tempMax = weatherModel.tempMax,
            dt = weatherModel.dt,
            name = weatherModel.name,
            id = maxItem
        )
        dao.insertHistoryItem(historyItem)
    }

    private suspend fun insertHistoryItemOverLimit(weatherModel: WeatherModel) {
        dao.deleteHistoryItemById(0)
        dao.updateHistory()
        val historyItem = HistoryItem(
            description = weatherModel.description,
            temp = weatherModel.temp,
            tempMax = weatherModel.tempMax,
            dt = weatherModel.dt,
            name = weatherModel.name,
            id = 4
        )
        dao.insertHistoryItem(historyItem)
    }

    override suspend fun insertHistoryItem(weatherModel: WeatherModel?) {
        if (weatherModel != null) {
            var maxItem = dao.getMaxHistoryItemId()
            maxItem = if(maxItem == null) {
                0
            } else {
                maxItem!! + 1
            }

            if(maxItem < 5) {
                insertHistoryItemUnderLimit(weatherModel, maxItem)
            } else {
                insertHistoryItemOverLimit(weatherModel)

            }
        }
    }
    override suspend fun getWeatherInfo(cityName: String): Resource<WeatherModel> {
        val response = try {
            api.getWeatherInfo(cityName = cityName)
        } catch (e: Exception) {
            return Resource.Error(UiText.StringResource(R.string.error_unknown))
        }
        return Resource.Success(response.toHistoryItem())
    }

    override fun list(): Flow<List<HistoryItem>> {
        return dao.getAllHistoryItems()
    }

}