package com.example.albionmarket.data.database.priceForItems

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "price_for_items")
data class PriceForItems(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "buy_price_max")
    val buyPriceMax: Int?,
    @ColumnInfo(name = "buy_price_max_date")
    val buyPriceMaxDate: String?,
    @ColumnInfo(name = "buy_price_min")
    val buyPriceMin: Int?,
    @ColumnInfo(name = "buy_price_min_date")
    val buyPriceMinDate: String?,
    @ColumnInfo(name = "city")
    val city: String?,
    @ColumnInfo(name = "item_id")
    val itemId: String?,
    @ColumnInfo(name = "quality")
    val quality: Int?,
    @ColumnInfo(name = "sell_price_max")
    val sellPriceMax: Int?,
    @ColumnInfo(name = "sell_price_max_date")
    val sellPriceMaxDate: String?,
    @ColumnInfo(name = "sell_price_min")
    val sellPriceMin: Int?,
    @ColumnInfo(name = "sell_price_min_date")
    val sellPriceMinDate: String?
)
