package com.example.albionmarket.data.network.itemRetrofitService

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ItemRetrofitService {

    val BASE_URL = "https://raw.githubusercontent.com/"

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

    val itemRetrofitServiceApi: ItemRetrofitServiceAPI = retrofit.create(ItemRetrofitServiceAPI::class.java)

}