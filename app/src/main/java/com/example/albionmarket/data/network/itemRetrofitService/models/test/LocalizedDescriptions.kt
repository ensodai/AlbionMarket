package com.example.albionmarket.data.network.itemRetrofitService.models.test


import com.google.gson.annotations.SerializedName

data class LocalizedDescriptions(
    @SerializedName("DE-DE")
    val dEDE: String?,
    @SerializedName("EN-US")
    val eNUS: String?,
    @SerializedName("ES-ES")
    val eSES: String?,
    @SerializedName("FR-FR")
    val fRFR: String?,
    @SerializedName("ID-ID")
    val iDID: String?,
    @SerializedName("IT-IT")
    val iTIT: String?,
    @SerializedName("JA-JP")
    val jAJP: String?,
    @SerializedName("KO-KR")
    val kOKR: String?,
    @SerializedName("PL-PL")
    val pLPL: String?,
    @SerializedName("PT-BR")
    val pTBR: String?,
    @SerializedName("RU-RU")
    val rURU: String?,
    @SerializedName("ZH-CN")
    val zHCN: String?,
    @SerializedName("ZH-TW")
    val zHTW: String?
)