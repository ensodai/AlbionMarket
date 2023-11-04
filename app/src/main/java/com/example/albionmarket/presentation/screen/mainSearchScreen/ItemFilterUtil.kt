package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.albionmarket.data.database.AlbionItemWithPrices
import com.example.albionmarket.data.database.LocationsData
import com.example.albionmarket.utilites.DragAnchors
import kotlin.math.roundToInt

fun filteredPrice(prices: AlbionItemWithPrices?): Map<String, String?> {
    val priceForCities = mapOf(
        LocationsData.Bridgewatch.nameCity to prices?.prices?.priceForCityBridgewatch,
        LocationsData.Caerleon.nameCity to prices?.prices?.priceForCityCaerleon,
        LocationsData.FortSterling.nameCity to prices?.prices?.priceForCityFortSterling,
        LocationsData.Lymhurst.nameCity to prices?.prices?.priceForCityLymhurst,
        LocationsData.Martlock.nameCity to prices?.prices?.priceForCityMartlock,
        LocationsData.Thetford.nameCity to prices?.prices?.priceForCityThetford
    )

    return priceForCities.filter { (key, value) ->
        value != "0" && key != "null" && key != "1"
    }
}

fun filteredItems(albionItemWithPrices: AlbionItemWithPrices?): AlbionItemWithPrices? {
    return albionItemWithPrices?.takeIf { item ->
        item.prices?.let { price ->
            price.priceForCityBridgewatch != "" &&
                    price.priceForCityCaerleon != "" &&
                    price.priceForCityFortSterling != "" &&
                    price.priceForCityLymhurst != "" &&
                    price.priceForCityMartlock != "" &&
                    price.priceForCityThetford != "" &&
                    price.priceForCityBridgewatch != "null" &&
                    price.priceForCityCaerleon != "null" &&
                    price.priceForCityFortSterling != "null" &&
                    price.priceForCityLymhurst != "null" &&
                    price.priceForCityMartlock != "null" &&
                    price.priceForCityThetford != "null"
        } ?: false
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun animateFavoriteCard(
    stateAnimationCard: AnchoredDraggableState<DragAnchors>
): Dp {
    val transition =
        updateTransition(targetState = stateAnimationCard.requireOffset().roundToInt(), label = "")

    val width by transition.animateDp(
        transitionSpec = {
            if (targetState == 0) {
                tween(durationMillis = 1000, easing = FastOutLinearInEasing)
            } else {
                tween(durationMillis = 500, easing = LinearOutSlowInEasing)
            }
        }, label = ""
    ) { targetValue ->
        targetValue.dp
    }
    return width
}

//fun localisedNames(albionItem: AlbionItem): String {
//    albionItem.getLocalizedNameByLanguageCode(albionItem)
//}