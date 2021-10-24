package com.tedm.newscompose.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tedm.newscompose.presentation.ui.theme.SpaceLarge
import com.tedm.newscompose.presentation.ui.theme.SpaceMedium
import com.tedm.newscompose.R
import com.tedm.newscompose.presentation.components.CustomButton
import com.tedm.newscompose.presentation.components.StandardTextField
import com.tedm.newscompose.presentation.ui.theme.SpaceSmall
import com.tedm.newscompose.presentation.util.Screen
import com.tedm.newscompose.util.UiEvent
import com.tedm.newscompose.util.asString
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
            }
        }
    }

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
                contentDescription = stringResource(id = R.string.logo),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(Modifier.height(IntrinsicSize.Min)) {
                Column(modifier = Modifier.weight(8f)) {
                    StandardTextField(
                        text = viewModel.cityText.value,
                        onValueChange = {
                            viewModel.setCityText(it)
                        },
                        keyboardType = KeyboardType.Email,
                        error = viewModel.cityError.value,
                        hint = stringResource(id = R.string.enter_city_name),
                    )
                }
                Spacer(modifier = Modifier.width(SpaceSmall))
                IconButton(
                    onClick = {
                        viewModel.getWeather()
                    },
                    modifier = Modifier
                        .weight(2f)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 16.dp,
                                bottomEnd = 16.dp,
                                bottomStart = 0.dp
                            )
                        )
                        .fillMaxSize()
                        .background(Color.White)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_green),
                        contentDescription = "Button",
                    )
                }
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            CustomButton(
                onButtonClick = {
                    navController.navigate(Screen.HistoryScreen.route)
                }
            )
            if (state.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}