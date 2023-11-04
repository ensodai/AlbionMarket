package com.example.albionmarket.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ButtonItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {

    object MainSearchScreenButton: ButtonItem(
        title = "Search",
        icon = Icons.Filled.AccountBox,
        route = ScreenRoute.MainSearchScreen.route
    )

    object FastTradeButton: ButtonItem(
        title = "Fast Trade",
        icon = Icons.Filled.AccountBox,
        route = ScreenRoute.FastTradeScreen.route
    )

    object CollectionsButton: ButtonItem(
        title = "Collections",
        icon = Icons.Filled.AccountBox,
        route = ScreenRoute.CollectionsScreen.route
    )

}