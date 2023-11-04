package com.example.albionmarket.di

import android.content.Context
import com.example.albionmarket.data.network.itemRetrofitService.ItemRetrofitService
import com.example.albionmarket.data.repository.Repository
import com.example.albionmarket.data.database.ItemsDataBase
import com.example.albionmarket.data.database.Dao
import com.example.albionmarket.data.network.priceRetrofitServise.PriceRetrofitService
import com.example.albionmarket.data.repository.Transformations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRetrofitServicesItems(): ItemRetrofitService {
        return ItemRetrofitService
    }

    @Provides
    fun provideRetrofitServicesPrice(): PriceRetrofitService {
        return PriceRetrofitService
    }

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context): Dao {
        return ItemsDataBase.getInstance(context).Dao()
    }

    @Provides
    fun provideTransformations(): Transformations{
        return Transformations()
    }

    @Provides
    @Singleton
    fun provideRepository(
        dao: Dao,
        retrofitServiceItems: ItemRetrofitService,
        retrofitServicePrice: PriceRetrofitService,
        transformations: Transformations
        ): Repository {
        return Repository(
            dao,
            retrofitServiceItems,
            retrofitServicePrice,
            transformations
        )
    }

}