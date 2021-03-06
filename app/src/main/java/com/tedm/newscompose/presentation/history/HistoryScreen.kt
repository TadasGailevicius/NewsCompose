package com.tedm.newscompose.presentation.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tedm.newscompose.presentation.components.HistoryItem
import com.tedm.newscompose.presentation.components.StandardToolbar
import kotlin.math.roundToInt

@Composable
fun HistoryScreen(
    navController: NavController,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val items by viewModel.historyItems.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StandardToolbar(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth(),
            showBackArrow = true,
        )
        LazyColumn {
            item {
                items?.forEach { historyItem ->
                    HistoryItem(
                        weatherModel = com.tedm.newscompose.domain.models.WeatherModel(
                            description = historyItem.description,
                            temp = historyItem.temp.roundToInt().toDouble(),
                            tempMin = historyItem.tempMin,
                            tempMax = historyItem.tempMax,
                            dt = historyItem.dt,
                            name = historyItem.name,
                            icon = historyItem.icon
                        )
                    )
                }
            }
        }
    }
}