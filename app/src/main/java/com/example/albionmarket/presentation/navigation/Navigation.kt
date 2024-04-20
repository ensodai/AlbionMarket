package com.example.albionmarket.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.albionmarket.presentation.screen.collectionScreen.CollectionsScreen
import com.example.albionmarket.presentation.screen.fastTradeScreen.FastTradeScreen
import com.example.albionmarket.presentation.screen.searchScreen.SearchScreen
import com.example.albionmarket.presentation.screen.collectionDetailsScreen.CollectionDetailsScreen
import com.example.albionmarket.presentation.screen.settingScreen.SettingScreen

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
        composable(route = ScreenRoute.SearchScreen.route) {
            SearchScreen(
                locale = locale
            )
        }
        composable(route = ScreenRoute.FastTradeScreen.route) {
            FastTradeScreen()
        }
        composable(route = ScreenRoute.CollectionsScreen.route) {
            CollectionsScreen()
        }
        composable(route = ScreenRoute.CollectionDetailsScreen.route) {
            CollectionDetailsScreen()
        }
        composable(route = ScreenRoute.SettingScreen.route) {
            SettingScreen()
        }
    }
}