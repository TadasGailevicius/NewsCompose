package com.tedm.newscompose.presentation.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
    val isLoading = remember { mutableStateOf(true) }
    val items by viewModel.notes.observeAsState()

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
                        historyItem = com.tedm.newscompose.domain.models.HistoryItem(
                            description = historyItem.description,
                            temp = historyItem.temp.roundToInt().toDouble(),
                            tempMax = historyItem.tempMax,
                            dt = historyItem.dt,
                            name = historyItem.name
                        )
                    )
                }
            }
        }
    }
}