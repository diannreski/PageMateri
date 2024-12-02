package com.example.newappwiser.navigation

sealed class Screen(val route: String) {
    object Video : Screen("video")
    object Berita : Screen("berita")
    object Artikel : Screen("artikel")
    object Main : Screen("main")
}
