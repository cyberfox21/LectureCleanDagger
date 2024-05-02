package com.example.androidcourse.data.datasource.remote

import com.example.androidcourse.data.entity.ShopItemDTO

/**
 * @author t.shkolnik
 */
interface RemoteDataSource {

    suspend fun getShopList(): List<ShopItemDTO>

    suspend fun getShopItem(shopItemId: Int): ShopItemDTO?

    suspend fun addShopItem(shopItemId: String, content: String)

    suspend fun editShopItem(shopItemId: String, content: String)

    suspend fun deleteShopItem(shopItemId: String, content: String)
}
