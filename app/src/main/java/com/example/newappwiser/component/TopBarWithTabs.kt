package com.example.newappwiser.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.example.newappwiser.R
import androidx.navigation.NavHostController
import androidx.compose.runtime.*


@Composable
fun TopBarWithTabs(
    navController: NavHostController,
    currentRoute: String,
    onTabSelected: (Int) -> Unit
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column {
        // Header with rounded corners and a background color
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(91.dp)
                .background(
                    color = Color(0xFF609AC1),
                    shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Materi Favorit",
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
            )

            // Back Button
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            // Video Tab
            Tab(
                selected = selectedTabIndex == 0,
                onClick = {
                    selectedTabIndex = 0
                    onTabSelected(0)  //
                }
            ) {
                TabContent(
                    isSelected = selectedTabIndex == 0,
                    text = "Video",
                    imageResId = R.drawable.v
                )
            }

            // Berita Tab
            Tab(
                selected = selectedTabIndex == 1,
                onClick = {
                    selectedTabIndex = 1
                    onTabSelected(1)
                }
            ) {
                TabContent(
                    isSelected = selectedTabIndex == 1,
                    text = "Berita",
                    imageResId = R.drawable.b
                )
            }

            // Artikel Tab
            Tab(
                selected = selectedTabIndex == 2,
                onClick = {
                    selectedTabIndex = 2
                    onTabSelected(2)
                }
            ) {
                TabContent(
                    isSelected = selectedTabIndex == 2,
                    text = "Artikel",
                    imageResId = R.drawable.a
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun TabContent(
    isSelected: Boolean,
    text: String,
    imageResId: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = text,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = if (isSelected) Color.Black else Color.Gray
        )
    }
}

