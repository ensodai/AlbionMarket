package com.example.albionmarket.domain.repository

interface RepositoryData {

    suspend fun getAllItems()

    suspend fun searchItem()

    suspend fun getItemsForCurrentCity()

    suspend fun addCollection()

    suspend fun deleteCollection()

    suspend fun getAllCollections()

    suspend fun getCurrentCollection()

    suspend fun addItemToCollection()

    suspend fun deleteItemFromCollection()


}