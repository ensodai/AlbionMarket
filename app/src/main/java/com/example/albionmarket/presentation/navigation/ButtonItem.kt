package com.example.albionmarket.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ButtonItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {

    data object SearchButton: ButtonItem(
        title = "Search",
        icon = Icons.Filled.AccountBox,
        route = ScreenRoute.SearchScreen.route
    )

    data object FastTradeButton: ButtonItem(
        title = "Fast Trade",
        icon = Icons.Filled.AccountBox,
        route = ScreenRoute.FastTradeScreen.route
    )

    data object CollectionsButton: ButtonItem(
        title = "Collections",
        icon = Icons.Filled.AccountBox,
        route = ScreenRoute.CollectionsScreen.route
    )

}