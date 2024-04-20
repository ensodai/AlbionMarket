package com.example.albionmarket.presentation.screen.searchScreen.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.albionmarket.data.db.models.AlbionItemWithPrices
import com.example.albionmarket.utilites.DragAnchors
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemCard(
    stateAnimationCard: AnchoredDraggableState<DragAnchors>,
    item: AlbionItemWithPrices?,
    locale: String
) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 6.dp)
            .offset {
                IntOffset(
                    x = stateAnimationCard
                        .requireOffset()
                        .roundToInt(),
                    y = 0,
                )
            }
            .anchoredDraggable(stateAnimationCard, Orientation.Horizontal),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column() {
            Row() {
                ImageItem(
                    item = item,
                    stateAnimationCard = stateAnimationCard
                )
                Column() {
                    if (item != null) {
                        item.albionItem.getLocalizedNameByLanguageCode(locale)
                            ?.let { Text(text = it) }
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    end = 20.dp,
                                    top = 3.dp,
                                    bottom = 6.dp
                                ),
                            thickness = 1.dp
                        )
                        PriceForItemCard(prices = item)
                    }
                }
            }
        }
    }
}