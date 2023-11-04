package com.example.albionmarket.data.repository

import com.example.albionmarket.data.database.albionItem.AlbionItem
import com.example.albionmarket.data.database.albionItem.AlbionItemDescription
import com.example.albionmarket.data.database.priceForItems.PriceForItems
import com.example.albionmarket.data.database.priceForItems.PriceForItemsLite
import com.example.albionmarket.data.network.itemRetrofitService.models.test.AlbionItemsModel
import com.example.albionmarket.data.network.priceRetrofitServise.models.PriceModel

class Transformations {

    fun filterItems(response: List<AlbionItemsModel>): List<AlbionItemsModel> {
        return response.filter { itemModel ->
            !itemModel.uniqueName.contains("QUEST", ignoreCase = true) &&
                    itemModel.localizedNames != null && itemModel.localizedDescriptions != null
        }
    }

    fun transformToAlbionItems(filteredItems: List<AlbionItemsModel>): List<AlbionItem?> {
        return filteredItems.map { itemModel ->
            itemModel.localizedNames?.let {
                AlbionItem(
                    uniqueName = itemModel.uniqueName,
                    favourites = false,
                    dEDE = it.dEDE,
                    eNUS = it.eNUS,
                    eSES = it.eSES,
                    fRFR = it.fRFR,
                    iDID = it.iDID,
                    iTIT = it.iTIT,
                    jAJP = it.jAJP,
                    kOKR = it.kOKR,
                    pLPL = it.pLPL,
                    pTBR = it.pTBR,
                    rURU = it.rURU,
                    zHCN = it.zHCN,
                    zHTW = it.zHTW
                )
            }
        }
    }

    fun transformToAlbionItemDescriptions(filteredItems: List<AlbionItemsModel>): List<AlbionItemDescription> {
        return filteredItems.map { itemModel ->
            AlbionItemDescription(
                uniqueName = itemModel.uniqueName,
                dEDE = itemModel.localizedDescriptions?.dEDE,
                eNUS = itemModel.localizedDescriptions?.eNUS,
                eSES = itemModel.localizedDescriptions?.eSES,
                fRFR = itemModel.localizedDescriptions?.fRFR,
                iDID = itemModel.localizedDescriptions?.iDID,
                iTIT = itemModel.localizedDescriptions?.iTIT,
                jAJP = itemModel.localizedDescriptions?.jAJP,
                kOKR = itemModel.localizedDescriptions?.kOKR,
                pLPL = itemModel.localizedDescriptions?.pLPL,
                pTBR = itemModel.localizedDescriptions?.pTBR,
                rURU = itemModel.localizedDescriptions?.rURU,
                zHCN = itemModel.localizedDescriptions?.zHCN,
                zHTW = itemModel.localizedDescriptions?.zHTW
            )
        }
    }

    fun transformToPriceForItems(response: List<PriceModel>): List<PriceForItems> {
        return response.map { priceModel ->
            PriceForItems(
                itemId = priceModel.itemId,
                city = priceModel.city,
                quality = priceModel.quality,
                sellPriceMin = priceModel.sellPriceMin,
                sellPriceMax = priceModel.sellPriceMax,
                sellPriceMinDate = priceModel.sellPriceMinDate,
                sellPriceMaxDate = priceModel.sellPriceMaxDate,
                buyPriceMin = priceModel.buyPriceMin,
                buyPriceMax = priceModel.buyPriceMax,
                buyPriceMinDate = priceModel.buyPriceMinDate,
                buyPriceMaxDate = priceModel.buyPriceMaxDate
            )
        }
    }

    fun transformToPriceForItemsLite(prices: List<PriceForItems>): PriceForItemsLite? {
        val priceForCityBridgewatch = getPriceForCity(prices, "Bridgewatch")
        val priceForCityCaerleon = getPriceForCity(prices, "Caerleon")
        val priceForCityFortSterling = getPriceForCity(prices, "Fort Sterling")
        val priceForCityLymhurst = getPriceForCity(prices, "Lymhurst")
        val priceForCityMartlock = getPriceForCity(prices, "Martlock")
        val priceForCityThetford = getPriceForCity(prices, "Thetford")

        val itemId = prices.firstOrNull()?.itemId

        return itemId?.let {
            PriceForItemsLite(
                itemId = it,
                priceForCityBridgewatch = priceForCityBridgewatch,
                priceForCityCaerleon = priceForCityCaerleon,
                priceForCityFortSterling = priceForCityFortSterling,
                priceForCityLymhurst = priceForCityLymhurst,
                priceForCityMartlock = priceForCityMartlock,
                priceForCityThetford = priceForCityThetford
            )
        }
    }

    private fun getPriceForCity(prices: List<PriceForItems>, city: String): String {
        val priceForCity = prices.find { it.city == city }
        return priceForCity?.buyPriceMax.toString()
    }

    fun chunked(itemNames: List<String>): List<List<String>> {
        val outputList = mutableListOf<List<String>>()
        var chunked = mutableListOf<String>()

        for (item in itemNames) {
            chunked.add(item)
            if (chunked.joinToString(",").length > 3960) {
                outputList.add(chunked)
                chunked = mutableListOf()
            }
        }

        if (chunked.isNotEmpty()) {
            outputList.add(chunked)
        }

        return outputList
    }

}