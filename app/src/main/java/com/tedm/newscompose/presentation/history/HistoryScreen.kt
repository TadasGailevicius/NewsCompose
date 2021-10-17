package com.tedm.newscompose.presentation.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.tedm.newscompose.presentation.components.HistoryItem
import com.tedm.newscompose.presentation.ui.theme.SpaceSmall

@Composable
fun HistoryScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HistoryItem(
            historyItem = com.tedm.newscompose.domain.models.HistoryItem(
                description = "overcast clouds",
                temp = 14.0,
                tempMax = 285.3,
                dt = 1634322168,
                name = "Kaunas"
            )
        )
        HistoryItem(
            historyItem = com.tedm.newscompose.domain.models.HistoryItem(
                description = "overcast clouds",
                temp = 16.0,
                tempMax = 285.3,
                dt = 1634322168,
                name = "Kaunas"
            )
        )
    }
    
}