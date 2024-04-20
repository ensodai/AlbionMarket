package com.example.albionmarket.data.db.models.priceForItems

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "price_for_items_lite")
data class PriceForItemsLite(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "item_id")
    val itemId: String,
    @ColumnInfo(name = "bridgewatch")
    val priceForCityBridgewatch: String,
    @ColumnInfo(name = "caerleon")
    val priceForCityCaerleon: String,
    @ColumnInfo(name = "fortSterling")
    val priceForCityFortSterling: String,
    @ColumnInfo(name = "lymhurst")
    val priceForCityLymhurst: String,
    @ColumnInfo(name = "martlock")
    val priceForCityMartlock: String,
    @ColumnInfo(name = "thetford")
    val priceForCityThetford: String,
)