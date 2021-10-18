package com.tedm.newscompose.presentation.history

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tedm.newscompose.domain.local.entities.HistoryItem
import com.tedm.newscompose.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.asLiveData

@HiltViewModel
class HistoryViewModel @Inject constructor (
    private val repository: WeatherRepository
) :ViewModel()  {

    val notes: LiveData<List<HistoryItem>> = repository.list().asLiveData()




}