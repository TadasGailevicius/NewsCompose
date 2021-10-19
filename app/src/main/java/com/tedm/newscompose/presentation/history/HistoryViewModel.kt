package com.tedm.newscompose.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tedm.newscompose.domain.local.entities.HistoryItem
import com.tedm.newscompose.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.asLiveData

@HiltViewModel
class HistoryViewModel @Inject constructor (
    private val repository: WeatherRepository
) :ViewModel()  {

    val historyItems: LiveData<List<HistoryItem>> = repository.list().asLiveData()




}