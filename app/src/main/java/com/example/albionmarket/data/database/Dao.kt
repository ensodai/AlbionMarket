package com.example.albionmarket.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.albionmarket.data.database.albionItem.AlbionItem
import com.example.albionmarket.data.database.albionItem.AlbionItemDescription
import com.example.albionmarket.data.database.priceForItems.PriceForItems
import com.example.albionmarket.data.database.priceForItems.PriceForItemsLite
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao  {

    @Insert
    fun insertAlbionItem(albionItem: AlbionItem)

    @Update
    fun updateAlbionItem(item: AlbionItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAlbionItems(items: List<AlbionItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDescriptions(items: List<AlbionItemDescription>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceForItems(priceForItems: List<PriceForItems>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceForItemsLite(priceForItems: List<PriceForItemsLite>)

    @Query("SELECT * FROM albion_items WHERE uniqueName = :uniqueName")
    fun getAlbionItemByUniqueName(uniqueName: String): AlbionItem

    @Query("SELECT * FROM albion_items")
    fun getAllAlbionItems(): PagingSource<Int, AlbionItem>

    @Query("SELECT uniqueName FROM albion_items")
    fun getAllUniqueNames(): List<String>

    @Query("DELETE FROM albion_items")
    fun clearAlbionItems()

    @Query("DELETE FROM price_for_items")
    fun clearPriceForItems()

    @Transaction
    fun clearAllTables() {
        clearAlbionItems()
        clearPriceForItems()
    }

    @Query("SELECT COUNT(*) FROM albion_items")
    fun getRowItemsCount(): Int

    @Query("SELECT COUNT(*) FROM price_for_items")
    fun getRowPricesCount(): Int

    @Query("SELECT * FROM albion_items")
    fun getAllItemsWithPrices(): PagingSource<Int, AlbionItemWithPrices>

    @Query("SELECT * FROM price_for_items")
    suspend fun getAllPrices(): List<PriceForItems>

    @Query("SELECT * FROM item_description WHERE uniqueName = :uniqueName")
    suspend fun getDescription(uniqueName: String): AlbionItemDescription?

    @Transaction
    @Query("SELECT * FROM albion_items WHERE uniqueName LIKE :query")
    fun searchAlbionItems(query: String): Flow<List<AlbionItemWithPrices?>>

}