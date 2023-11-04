package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.albionmarket.data.database.AlbionItemWithPrices
import com.example.albionmarket.utilites.DragAnchors
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteCard(
    itemsList: AlbionItemWithPrices?,
    stateAnimationCard: AnchoredDraggableState<DragAnchors>
) {
    Box() {
        Card(
            modifier = Modifier
                .height(
                    animateFavoriteCard(stateAnimationCard)
                )
                .padding(all = 6.dp)
                .offset {
                    IntOffset(
                        x = stateAnimationCard
                            .requireOffset()
                            .roundToInt() - 150,
                        y = 0,
                    )
                }
                .anchoredDraggable(stateAnimationCard, Orientation.Horizontal)
        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                val icon = if (itemsList?.albionItem?.favourites == true) {
                    Icons.Filled.Favorite
                } else Icons.Outlined.FavoriteBorder
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                )
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = null,
                )
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null,
                )
            }
        }
    }
}