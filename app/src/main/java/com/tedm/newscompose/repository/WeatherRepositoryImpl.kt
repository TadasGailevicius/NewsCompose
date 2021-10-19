package com.tedm.newscompose.repository

import com.tedm.newscompose.domain.remote.WeatherApi
import com.tedm.newscompose.util.Resource
import com.tedm.newscompose.util.UiText
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import com.tedm.newscompose.R
import com.tedm.newscompose.domain.local.HistoryItemDao
import com.tedm.newscompose.domain.models.HistoryItem
import kotlinx.coroutines.flow.Flow

@ActivityScoped
class WeatherRepositoryImpl @Inject constructor(
    private val dao: HistoryItemDao,
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun insertHistoryItem(historyItem: HistoryItem?) {
        if (historyItem != null) {
            var maxItem = dao.getMaxHistoryItemId()
            maxItem = if(maxItem == null) {
                0
            } else {
                maxItem!! + 1
            }

            if(maxItem < 5) {
                val historyItem = com.tedm.newscompose.domain.local.entities.HistoryItem(
                    description = historyItem.description,
                    temp = historyItem.temp,
                    tempMax = historyItem.tempMax,
                    dt = historyItem.dt,
                    name = historyItem.name,
                    id = maxItem
                )
                dao.insertHistoryItem(historyItem)
            } else {
                dao.deleteHistoryItemById(0)
                dao.updateHistory()
                val historyItem = com.tedm.newscompose.domain.local.entities.HistoryItem(
                    description = historyItem.description,
                    temp = historyItem.temp,
                    tempMax = historyItem.tempMax,
                    dt = historyItem.dt,
                    name = historyItem.name,
                    id = 4
                )
                dao.insertHistoryItem(historyItem)
            }
        }
    }
    override suspend fun getWeatherInfo(cityName: String): Resource<HistoryItem> {
        val response = try {
            api.getWeatherInfo(cityName = cityName)
        } catch (e: Exception) {
            return Resource.Error(UiText.StringResource(R.string.error_unknown))
        }
        return Resource.Success(response.toHistoryItem())
    }

    override fun list(): Flow<List<com.tedm.newscompose.domain.local.entities.HistoryItem>> {
        return dao.getAllHistoryItems()
    }

}