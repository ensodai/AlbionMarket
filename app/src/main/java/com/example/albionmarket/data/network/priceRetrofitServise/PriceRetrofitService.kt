package com.example.albionmarket.data.network.priceRetrofitServise

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PriceRetrofitService {

    val BASE_URL = "https://west.albion-online-data.com/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()


    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val itemRetrofitServiceApi: PriceRetrofitServiceAPI = retrofit.create(PriceRetrofitServiceAPI::class.java)

}