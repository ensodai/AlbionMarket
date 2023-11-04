package com.example.albionmarket.data.network.itemRetrofitService.models.test


import com.google.gson.annotations.SerializedName

data class AlbionItemsModel(
    @SerializedName("Index")
    val index: String,
    @SerializedName("LocalizationDescriptionVariable")
    val localizationDescriptionVariable: String,
    @SerializedName("LocalizationNameVariable")
    val localizationNameVariable: String,
    @SerializedName("LocalizedDescriptions")
    val localizedDescriptions: LocalizedDescriptions?,
    @SerializedName("LocalizedNames")
    val localizedNames: LocalizedNames?,
    @SerializedName("UniqueName")
    val uniqueName: String
)