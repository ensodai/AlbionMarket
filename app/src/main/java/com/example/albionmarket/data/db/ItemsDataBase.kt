package com.example.albionmarket.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.albionmarket.data.db.models.albionItem.AlbionItem
import com.example.albionmarket.data.db.models.albionItem.AlbionItemDescription
import com.example.albionmarket.data.db.models.Favourites
import com.example.albionmarket.data.db.models.priceForItems.PriceForItems
import com.example.albionmarket.data.db.models.priceForItems.PriceForItemsLite

@Database(
    entities = [
        AlbionItem::class,
        PriceForItems::class,
        AlbionItemDescription::class,
        PriceForItemsLite::class,
        Favourites::class
    ],
    version = 19,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class ItemsDataBase : RoomDatabase() {
    abstract fun Dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: ItemsDataBase? = null

        fun getInstance(context: Context): ItemsDataBase {
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                ItemsDataBase::class.java,
                "AlbionDataBase"
            ).fallbackToDestructiveMigration().build().also {
                INSTANCE = it
                Log.d("AlbionDataBase", "Database instance created")
            }
        }
    }
}

//.fallbackToDestructiveMigration()