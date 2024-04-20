package com.example.albionmarket.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.albionmarket.presentation.screen.mainScreen.MainScreen
import com.example.albionmarket.ui.theme.AlbionMarketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlbionMarketTheme {
                MainScreen()
            }
        }
    }
}