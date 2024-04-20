package com.example.albionmarket.presentation.screen.searchScreen.component

import com.example.albionmarket.data.db.models.AlbionItemWithPrices
import com.example.albionmarket.data.db.LocationsData

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

