package com.example.albionmarket.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.albionmarket.presentation.screen.CollectionsScreen
import com.example.albionmarket.presentation.screen.FastTradeScreen
import com.example.albionmarket.presentation.screen.mainSearchScreen.MainSearchScreen
import com.example.albionmarket.presentation.screen.OpenCollectionScreen
import com.example.albionmarket.presentation.screen.SettingScreen

@Composable
fun Navigation(
    navController: NavHostController,
    startDestination: String,
    bottomPaddingValues: PaddingValues,
    locale: String
//    itemsList: LazyPagingItems<AlbionItem>
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = ScreenRoute.MainSearchScreen.route) {
            MainSearchScreen(
                locale = locale

            )
        }
        composable(route = ScreenRoute.FastTradeScreen.route) {
            FastTradeScreen()
        }
        composable(route = ScreenRoute.CollectionsScreen.route) {
            CollectionsScreen()
        }
        composable(route = ScreenRoute.OpenCollectionScreen.route) {
            OpenCollectionScreen()
        }
        composable(route = ScreenRoute.SettingScreen.route) {
            SettingScreen()
        }
    }
}