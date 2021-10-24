package com.tedm.newscompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.tedm.newscompose.domain.models.WeatherModel
import com.tedm.newscompose.presentation.ui.theme.SpaceMedium
import com.tedm.newscompose.presentation.ui.theme.SpaceSmall
import java.time.Instant
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.*
import kotlin.math.roundToInt

@Composable
fun HistoryItem(
    modifier: Modifier = Modifier,
    weatherModel: WeatherModel,
    onHistoryItemClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaceMedium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.large)
                .clickable {
                    onHistoryItemClick()
                }
                .background(Color.LightGray.copy(alpha = 0.35f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceMedium)
            ) {
                Row {
                    Image(
                        painter = rememberImagePainter("http://openweathermap.org/img/wn/${weatherModel.icon}@2x.png"),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = buildAnnotatedString {
                            append(weatherModel.description)
                        },
                        style = MaterialTheme.typography.body2,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                }
                Spacer(modifier = Modifier.height(SpaceSmall))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append(weatherModel.name)
                        },
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.h2,
                        color = when {
                            weatherModel.temp <= 10 -> {
                                Color.Yellow
                            }
                            weatherModel.temp < 20 -> {
                                Color.Red
                            }
                            else -> {
                                Color.Green
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(SpaceSmall))
                    Text(
                        text = buildAnnotatedString {
                            append(weatherModel.temp.roundToInt().toString())
                            append("°")
                        },
                        fontSize = 96.sp,
                        style = MaterialTheme.typography.h2,
                        color = when {
                            weatherModel.temp <= 10 -> {
                                Color.Green
                            }
                            weatherModel.temp < 20 -> {
                                Color.Yellow
                            }
                            else -> {
                                Color.Red
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(SpaceSmall))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                val dt = Instant.ofEpochSecond(weatherModel.dt.toLong())
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime()
                                append(
                                    dt.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US)
                                        .toString()
                                )
                            },
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.h2,
                            color = when {
                                weatherModel.temp <= 10 -> {
                                    Color.Red
                                }
                                weatherModel.temp < 20 -> {
                                    Color.Green
                                }
                                else -> {
                                    Color.Yellow
                                }
                            }
                        )

                        Text(
                            text = buildAnnotatedString {
                                val dt = Instant.ofEpochSecond(weatherModel.dt.toLong())
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDateTime()
                                append(dt.dayOfMonth.toString())
                            },
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.h2,
                            color = when {
                                weatherModel.temp <= 10 -> {
                                    Color.Red
                                }
                                weatherModel.temp < 20 -> {
                                    Color.Green
                                }
                                else -> {
                                    Color.Yellow
                                }
                            }
                        )

                    }
                }
            }
        }
    }

}