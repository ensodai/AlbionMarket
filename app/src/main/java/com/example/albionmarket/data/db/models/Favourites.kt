package com.example.albionmarket.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class Favourites(
    @PrimaryKey val collectionName: String,
    @ColumnInfo(name = "uniqueNames")
    val uniqueNames: String
)