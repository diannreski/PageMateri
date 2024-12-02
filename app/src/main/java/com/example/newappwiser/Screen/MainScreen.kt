package com.example.newappwiser.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newappwiser.component.MateriItem
import com.example.newappwiser.component.TopBarWithTabs
import com.example.newappwiser.R

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    // Data dummy untuk setiap tab
    val data = when (selectedTabIndex) {
        0 -> listOf(
            Materi("Pengenalan Budidaya Walet", "Deskripsi materi", R.drawable.v),
            Materi("Konstruksi Gedung Walet", "Deskripsi materi", R.drawable.v)
        )
        1 -> listOf(
            Materi("Barantin Akan Tingkatkan Devisa", "Berita terbaru tentang walet", R.drawable.v),
            Materi("Sarang Burung Walet dalam Pengobatan", "Informasi tradisional walet", R.drawable.v)
        )
        2 -> listOf(
            Materi("Menuju Sukses dengan Budidaya Sarang Burung Walet", "Artikel menarik", R.drawable.images),
            Materi("Kandungan Nitrit pada Sarang Burung Walet", "Artikel kesehatan", R.drawable.nirit)
        )
        else -> emptyList() // Tab kosong
    }

    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            // Top Bar dan Tab
            TopBarWithTabs(
                navController = navController,
                currentRoute = navController.currentBackStackEntry?.destination?.route ?: "",
                onTabSelected = { selectedTabIndex = it }
            )

            // Daftar Materi di bawah
            LazyColumn {
                items(data) { materi ->
                    MateriItem(
                        title = materi.title,
                        description = materi.description,
                        imageRes = materi.imageRes,
                        navController = navController,
                        targetRoute = "target_route"
                    )
                }
            }
        }
    }
}

// Data class untuk Materi
data class Materi(
    val title: String,
    val description: String,
    val imageRes: Int
)

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
