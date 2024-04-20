package com.example.albionmarket.presentation.screen.mainScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.albionmarket.presentation.navigation.BottomNavigation
import com.example.albionmarket.presentation.navigation.Navigation
import com.example.albionmarket.presentation.navigation.ScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val startDestination = ScreenRoute.SearchScreen.route
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val testLocale = "RU-RU"
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