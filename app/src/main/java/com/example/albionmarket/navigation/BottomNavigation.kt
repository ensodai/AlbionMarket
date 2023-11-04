package com.example.albionmarket.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun BottomNavigation(navController: NavController) {

    val listButtonItem = listOf(
        ButtonItem.MainSearchScreenButton,
        ButtonItem.FastTradeButton,
        ButtonItem.CollectionsButton
    )

    var selectedButton by remember { mutableStateOf(0) }

    NavigationBar(modifier = Modifier
        .padding(bottom = 30.dp)
        .padding(horizontal = 100.dp)
        .height(60.dp)
        .clip(
            RoundedCornerShape(30.dp)
        )
//        .background(
//            color = Color.White.copy(alpha = 0.7f)
//        )
    ) {
        listButtonItem.forEachIndexed{ index, item ->
            NavigationBarItem(
                icon = {
                    Icon(imageVector = item.icon,
                        contentDescription = item.title)
                },
                selected = selectedButton == index,
                onClick = {
                    selectedButton = index
                    navController.navigate(item.route){
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                alwaysShowLabel = true
            )
        }
    }
}