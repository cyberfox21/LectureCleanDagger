package com.example.androidcourse.di.module

import android.content.Context
import androidx.room.Room
import com.example.androidcourse.data.datasource.local.AppDatabase
import com.example.androidcourse.data.datasource.local.ShopItemDao
import com.example.androidcourse.data.datasource.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author t.shkolnik
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(CONTENT_TYPE.toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
    }

    @Provides
    @Singleton
    fun provideShopItemDao(database: AppDatabase): ShopItemDao {
        return database.shopItemDao()
    }

    private companion object {

        private const val DB_NAME = "shop_item.db"
        private const val CONTENT_TYPE = "application/json"
        private const val BASE_URL = "https://api.example.com/"
    }
}