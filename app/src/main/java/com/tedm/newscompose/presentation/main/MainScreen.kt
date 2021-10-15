package com.tedm.newscompose.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tedm.newscompose.presentation.ui.theme.SpaceLarge
import com.tedm.newscompose.presentation.ui.theme.SpaceMedium
import com.tedm.newscompose.R
import com.tedm.newscompose.presentation.components.StandardTextField

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
                },
                keyboardType = KeyboardType.Email,
                error = viewModel.usernameError.value,
                hint = stringResource(id = R.string.enter_city_name)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    /*TODO*/
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow.copy(alpha = 0.5f)),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.view_history),
                    color = MaterialTheme.colors.onSurface
                )
            }

        }

    }
}