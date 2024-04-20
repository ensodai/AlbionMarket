package com.example.albionmarket.presentation.screen.searchScreen.component

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.albionmarket.data.db.models.AlbionItemWithPrices
import com.example.albionmarket.utilites.DragAnchors

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentForItem(
    item: AlbionItemWithPrices?,
    locale: String,
) {
    val density = LocalDensity.current
    val stateAnimationCard = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors.Start,
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium,
            ),
        ).apply {
            updateAnchors(
                DraggableAnchors {
                    DragAnchors.Start at 0f
                    DragAnchors.End at 150f
                }
            )
        }
    }
    Box() {
        FavoriteCard(
            itemsList = item,
            stateAnimationCard = stateAnimationCard
        )
        ItemCard(
            stateAnimationCard = stateAnimationCard,
            item = item,
            locale = locale
        )
    }
}

