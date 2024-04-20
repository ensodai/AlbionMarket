package com.example.albionmarket.data.repository

import android.util.Log
import androidx.paging.PagingSource
import com.example.albionmarket.data.db.models.AlbionItemWithPrices
import com.example.albionmarket.data.network.itemRetrofitService.ItemRetrofitService
import com.example.albionmarket.data.db.models.albionItem.AlbionItem
import com.example.albionmarket.data.db.Dao
import com.example.albionmarket.data.db.models.albionItem.AlbionItemDescription
import com.example.albionmarket.data.db.models.priceForItems.PriceForItemsLite
import com.example.albionmarket.data.network.priceRetrofitServise.PriceRetrofitService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dao: Dao,
    private val retrofitServiceItems: ItemRetrofitService,
    private val retrofitServicePrice: PriceRetrofitService,
    private val mapper: Mapper
) {

    suspend fun getItemDescription(itemName: String): AlbionItemDescription? {
        return dao.getDescription(itemName)
    }

    fun pagingData(): PagingSource<Int, AlbionItemWithPrices> {
        return dao.getAllItemsWithPrices()
    }

    suspend fun loadAlbionItemsFromGithub() {
        if (dao.getRowItemsCount() == 0 && dao.getRowPricesCount() == 0) {
            val response = retrofitServiceItems.itemRetrofitServiceApi.getItems()
            val filteredItems = mapper.filterItems(response)
            val itemList = mapper.transformToAlbionItems(filteredItems)
            val descriptionsList = mapper.transformToAlbionItemDescriptions(filteredItems)
            dao.insertAllAlbionItems(itemList as List<AlbionItem>)
            dao.insertAllDescriptions(descriptionsList)
            loadAllPriceForItems()
        }
    }

    private suspend fun loadAllPriceForItems() {
        val locations = "0007,1002,2004,3005,3008,4002"
        val qualities = "1,2,3,4,5"
        val allItems = mapper.chunked(dao.getAllUniqueNames())
        for (chunkedItems in allItems) {
            val itemIds = chunkedItems.joinToString(",")
            try {
                val response = retrofitServicePrice.itemRetrofitServiceApi.getItemPrices(
                    itemIds,
                    locations,
                    qualities
                )
                val priceList = mapper.transformToPriceForItems(response)
                dao.insertPriceForItems(priceList)
            } catch (e: Exception) {
                Log.d("Repository", e.toString())
            }
            val allPrices = dao.getAllPrices()
            val groupedPrices = allPrices.groupBy { it.itemId }
            val itemPriceLiteList = mutableListOf<PriceForItemsLite>()

            for ((itemId, prices) in groupedPrices) {
                val itemPriceLite = mapper.transformToPriceForItemsLite(prices)
                itemPriceLite?.let { itemPriceLiteList.add(it) }

                if (itemPriceLite != null) {
                    itemPriceLiteList.add(itemPriceLite)
                }
            }
            dao.insertPriceForItemsLite(itemPriceLiteList)
        }
    }

    fun clearDatabase() {
        dao.clearAllTables()
    }

}