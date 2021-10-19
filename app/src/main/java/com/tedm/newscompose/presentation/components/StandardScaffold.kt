package com.tedm.newscompose.presentation.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun StandardScaffold(
    navController: NavController,
    showBackArrow: Boolean = true,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier
    ) {
        content()
    }
    
}