package com.example.albionmarket.data.database.albionItem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_description")
data class AlbionItemDescription(
    @PrimaryKey val uniqueName: String,
    @ColumnInfo("DE-DE") val dEDE: String?,
    @ColumnInfo("EN-US") val eNUS: String?,
    @ColumnInfo("ES-ES") val eSES: String?,
    @ColumnInfo("FR-FR") val fRFR: String?,
    @ColumnInfo("ID-ID") val iDID: String?,
    @ColumnInfo("IT-IT") val iTIT: String?,
    @ColumnInfo("JA-JP") val jAJP: String?,
    @ColumnInfo("KO-KR") val kOKR: String?,
    @ColumnInfo("PL-PL") val pLPL: String?,
    @ColumnInfo("PT-BR") val pTBR: String?,
    @ColumnInfo("RU-RU") val rURU: String?,
    @ColumnInfo("ZH-CN") val zHCN: String?,
    @ColumnInfo("ZH-TW") val zHTW: String?
)