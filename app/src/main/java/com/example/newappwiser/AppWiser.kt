package com.example.newappwiser

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newappwiser.component.TopBarWithTabs
import com.example.newappwiser.navigation.Screen
import com.example.newappwiser.Screen.ArtikelScreen
import com.example.newappwiser.Screen.BeritaScreen
import com.example.newappwiser.Screen.VideoScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppWiser(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // Get current route to determine the active tab
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Screen.Video.route // Set default to VideoScreen

    // Scaffold with Top Bar only at the top
    Scaffold(
        topBar = {
            // Top Bar hanya muncul sekali di bagian atas
            TopBarWithTabs(
                navController = navController,
                currentRoute = currentRoute,
                onTabSelected = { index ->
                    when (index) {
                        0 -> navController.navigate(Screen.Video.route) {
                            launchSingleTop = true
                        } // Navigate to VideoScreen
                        1 -> navController.navigate(Screen.Berita.route) {
                            launchSingleTop = true
                        } // Navigate to Berita
                        2 -> navController.navigate(Screen.Artikel.route) {
                            launchSingleTop = true
                        } // Navigate to Artikel
                    }
                }
            )
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Video.route, // Start with VideoScreen
            modifier = modifier.padding(contentPadding)
        ) {
            composable(route = Screen.Video.route) {
                VideoScreen(navController = navController)
            }
            composable(route = Screen.Berita.route) {
                BeritaScreen(navController = navController)
            }
            composable(route = Screen.Artikel.route) {
                ArtikelScreen(navController = navController)
            }
        }
    }
}