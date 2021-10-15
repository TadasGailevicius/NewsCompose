package com.tedm.newscompose.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
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
import com.tedm.newscompose.presentation.ui.theme.SpaceSmall
import com.tedm.newscompose.presentation.util.Screen

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val matrix = ColorMatrix()
    matrix.setToSaturation(1F)
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
            Row() {
                Column(modifier = Modifier.weight(8f)) {
                    StandardTextField(
                        text = viewModel.usernameText.value,
                        onValueChange = {
                            viewModel.setUsernameText(it)
                        },
                        keyboardType = KeyboardType.Email,
                        error = viewModel.usernameError.value,
                        hint = stringResource(id = R.string.enter_city_name),
                    )
                }
                Spacer(modifier = Modifier.width(SpaceSmall))
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .background(Color.White)
                        .clip(RoundedCornerShape(topStart = 16.dp,topEnd = 0.dp,bottomEnd = 0.dp,bottomStart = 16.dp))
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_green),
                            contentDescription = "Button",
                            colorFilter = ColorFilter.colorMatrix(matrix)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    navController.navigate(Screen.HistoryScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray.copy(alpha = 0.35f)),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(MaterialTheme.shapes.large)
            ) {
                Text(
                    text = stringResource(id = R.string.view_history),
                    color = MaterialTheme.colors.onSurface
                )
            }

        }

    }
}