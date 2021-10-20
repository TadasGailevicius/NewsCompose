package com.tedm.newscompose.presentation.components

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun StandardScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    showBackArrow: Boolean = true,
    state: ScaffoldState,
    content: @Composable () -> Unit,
) {
    Scaffold(
        scaffoldState = state,
        modifier = modifier
    ) {
        content()
    }
    
}