package com.tedm.newscompose.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tedm.newscompose.R
import com.tedm.newscompose.presentation.ui.theme.SpaceLarge
import com.tedm.newscompose.presentation.ui.theme.SpaceSmall

@Composable
fun StandardToolbar(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    navActions: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {},
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = if (showBackArrow) {
            {
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    },
                ) {
                    Icon(
                        painterResource(id = R.drawable.arrow_back),
                        contentDescription = stringResource(id = R.string.arrow_back) 
                    )
                }
            }
        } else null,
        actions = navActions,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}