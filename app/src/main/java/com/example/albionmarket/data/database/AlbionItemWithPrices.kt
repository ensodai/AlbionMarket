package com.example.albionmarket.data.database

import androidx.room.Embedded
import androidx.room.Relation
import com.example.albionmarket.data.database.albionItem.AlbionItem
import com.example.albionmarket.data.database.priceForItems.PriceForItemsLite

data class AlbionItemWithPrices(
    @Embedded val albionItem: AlbionItem,
    @Relation(
        parentColumn = "uniqueName",
        entityColumn = "item_id"
    )
    val prices: PriceForItemsLite?
)