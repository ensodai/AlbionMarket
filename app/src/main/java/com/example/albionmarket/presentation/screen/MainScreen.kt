package com.example.albionmarket.presentation.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.albionmarket.navigation.BottomNavigation
import com.example.albionmarket.navigation.Navigation
import com.example.albionmarket.navigation.ScreenRoute
import com.example.albionmarket.presentation.viewModel.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val startDestination = ScreenRoute.MainSearchScreen.route
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val testLocale = "EN-US"
    val locale = testLocale

    Scaffold(
        bottomBar = { BottomNavigation(navController) }
    ) { bottomPaddingValues ->
        Navigation(
            navController = navController,
            startDestination = startDestination,
            bottomPaddingValues = bottomPaddingValues,
            locale = locale
        )
    }
}