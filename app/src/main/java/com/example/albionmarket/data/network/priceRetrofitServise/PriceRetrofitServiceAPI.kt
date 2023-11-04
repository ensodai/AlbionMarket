package com.example.albionmarket.data.network.priceRetrofitServise


import com.example.albionmarket.data.network.priceRetrofitServise.models.PriceModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PriceRetrofitServiceAPI {

    @GET("api/v1/stats/prices/{{itemTypeId}}")
    suspend fun getItemPrices(
        @Path("itemTypeId") itemTypeId: String,
        @Query("locations") locations: String,
        @Query("qualities") qualities: String
    ): List<PriceModel>

}