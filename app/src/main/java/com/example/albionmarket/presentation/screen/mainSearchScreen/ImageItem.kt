package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.albionmarket.data.database.AlbionItemWithPrices
import com.example.albionmarket.utilites.DragAnchors
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PictureItem(item: AlbionItemWithPrices?, stateAnimationCard: AnchoredDraggableState<DragAnchors>) {

    SubcomposeAsyncImage(
        model = "https://render.albiononline.com/v1/item/${item?.albionItem?.uniqueName}.png?size=70",
        contentDescription = null,
        modifier = Modifier
            .size(90.dp)
            .clickable {

            }
            .offset {
                IntOffset(
                    x = 0,
                    y = stateAnimationCard
                        .requireOffset()
                        .roundToInt() / 10,
                )
            },
        loading = { CircularProgressIndicator() }
    )

}