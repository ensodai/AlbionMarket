package com.example.albionmarket.navigation

sealed class ScreenRoute(val route: String) {

    object CollectionsScreen: ScreenRoute(route = "collections_screen")
    object FastTradeScreen: ScreenRoute(route = "fast_trade_screen")
    object MainSearchScreen: ScreenRoute(route = "main_search_screen")
    object SettingScreen: ScreenRoute(route = "setting_screen")
    object OpenCollectionScreen: ScreenRoute(route = "open_collection_screen")

}