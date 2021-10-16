package com.tedm.newscompose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.tedm.newscompose.domain.models.HistoryItem
import com.tedm.newscompose.presentation.ui.theme.SpaceMedium
import com.tedm.newscompose.presentation.ui.theme.SpaceSmall
import com.tedm.newscompose.R

@Composable
fun HistoryItem(
    modifier: Modifier = Modifier,
    historyItem: HistoryItem,
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
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Weathwer"
                    )
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = buildAnnotatedString {
                            append(historyItem.description)
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
                            append(historyItem.name)
                        },
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.h2
                    )
                    Spacer(modifier = Modifier.height(SpaceSmall))
                    Text(
                        text = buildAnnotatedString {
                            append(historyItem.temp.toString())
                            append("°")
                        },
                        fontSize = 96.sp,
                        style = MaterialTheme.typography.h2,
                    )
                    Spacer(modifier = Modifier.height(SpaceSmall))
                    Text(
                        text = buildAnnotatedString {
                            append("SAT\n01")
                        },
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.h2
                    )
                }
            }

        }
    }

}