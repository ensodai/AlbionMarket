package com.example.albionmarket.presentation.navigation

sealed class ScreenRoute(val route: String) {

    data object CollectionsScreen: ScreenRoute(route = "collections_screen")
    data object FastTradeScreen: ScreenRoute(route = "fast_trade_screen")
    data object SearchScreen: ScreenRoute(route = "search_screen")
    data object SettingScreen: ScreenRoute(route = "setting_screen")
    data object CollectionDetailsScreen: ScreenRoute(route = "collection_details_screen")

}