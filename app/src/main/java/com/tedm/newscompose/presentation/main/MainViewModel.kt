package com.tedm.newscompose.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tedm.newscompose.domain.use_case.WeatherUseCases
import com.tedm.newscompose.repository.WeatherRepository
import com.tedm.newscompose.util.Resource
import com.tedm.newscompose.util.UiEvent
import com.tedm.newscompose.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherUseCases: WeatherUseCases,
    private val repository: WeatherRepository
) : ViewModel() {

    private val _cityText = mutableStateOf("")
    val cityText: State<String> = _cityText

    private val _cityError = mutableStateOf("")
    val cityError: State<String> = _cityError

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun setCityText(username: String) {
        _cityText.value = username
    }

    fun setIsCityError(error: String) {
        _cityError.value = error
    }

    fun getCityName(): String {
        return _cityText.value
    }

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    private fun insertHistoryItem() = viewModelScope.launch {
        repository.insertHistoryItem(historyItem = state.value.historyItem)
    }

    fun getWeather() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoading = true
            )
            val result = weatherUseCases.getWeather(
                cityName = _cityText.value
            )
            when (result) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        historyItem = result.data,
                        isLoading = false
                    )
                    insertHistoryItem()
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(
                            uiText = result.uiText ?: UiText.cityHasBeenLoaded()
                        )
                    )

                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(
                            uiText = result.uiText ?: UiText.unknownError()
                        )
                    )
                }
            }
        }
    }
}