package com.example.newappwiser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.newappwiser.ui.theme.NewAppWiserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewAppWiserTheme {
                AppWiser(

                )
            }
        }
    }
}
