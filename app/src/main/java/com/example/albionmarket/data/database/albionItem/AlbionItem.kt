package com.example.albionmarket.data.database.albionItem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "albion_items")
data class  AlbionItem(
    @PrimaryKey val uniqueName: String,
    @ColumnInfo(name ="favourites") val favourites: Boolean,
    @ColumnInfo(name ="DE-DE") val dEDE: String,
    @ColumnInfo(name ="EN-US") val eNUS: String,
    @ColumnInfo(name ="ES-ES") val eSES: String,
    @ColumnInfo(name ="FR-FR") val fRFR: String,
    @ColumnInfo(name ="ID-ID") val iDID: String,
    @ColumnInfo(name ="IT-IT") val iTIT: String,
    @ColumnInfo(name ="JA-JP") val jAJP: String,
    @ColumnInfo(name ="KO-KR") val kOKR: String,
    @ColumnInfo(name ="PL-PL") val pLPL: String,
    @ColumnInfo(name ="PT-BR") val pTBR: String,
    @ColumnInfo(name ="RU-RU") val rURU: String,
    @ColumnInfo(name ="ZH-CN") val zHCN: String,
    @ColumnInfo(name ="ZH-TW") val zHTW: String,
){
    fun getLocalizedNameByLanguageCode(languageCode: String): String? {
        return when (languageCode) {
            "DE-DE" -> dEDE
            "EN-US" -> eNUS
            "ES-ES" -> eSES
            "FR-FR" -> fRFR
            "ID-ID" -> iDID
            "IT-IT" -> iTIT
            "JA-JP" -> jAJP
            "KO-KR" -> kOKR
            "PL-PL" -> pLPL
            "PT-BR" -> pTBR
            "RU-RU" -> rURU
            "ZH-CN" -> zHCN
            "ZH-TW" -> zHTW
            else -> null
        }
    }
}