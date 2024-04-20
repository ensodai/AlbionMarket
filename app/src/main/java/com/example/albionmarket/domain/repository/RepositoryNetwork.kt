package com.example.albionmarket.domain.repository

interface RepositoryNetwork {

    suspend fun loadItemData()

    suspend fun refreshAllItemData()

    suspend fun loadPriceForAllItems()

    suspend fun refreshPriceForAllItems()

    suspend fun refreshPriceForCurrentCity()

    suspend fun refreshPriceItem()

    suspend fun refreshAllCollections()

    suspend fun refreshCurrentCollection()

}