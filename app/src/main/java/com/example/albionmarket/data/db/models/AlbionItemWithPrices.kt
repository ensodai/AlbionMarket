package com.example.albionmarket.data.db.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.albionmarket.data.db.models.albionItem.AlbionItem
import com.example.albionmarket.data.db.models.priceForItems.PriceForItemsLite

data class AlbionItemWithPrices(
    @Embedded val albionItem: AlbionItem,
    @Relation(
        parentColumn = "uniqueName",
        entityColumn = "item_id"
    )
    val prices: PriceForItemsLite?
)