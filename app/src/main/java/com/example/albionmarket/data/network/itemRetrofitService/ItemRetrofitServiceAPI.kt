package com.example.albionmarket.data.network.itemRetrofitService

import com.example.albionmarket.data.network.itemRetrofitService.models.test.AlbionItemsModel
import retrofit2.http.GET

interface ItemRetrofitServiceAPI {

    @GET("ao-data/ao-bin-dumps/master/formatted/items.json")
    suspend fun getItems(): List<AlbionItemsModel>

}