package com.example.androidcourse.data.datasource.local

import com.example.androidcourse.data.entity.ShopItemDbModel

/**
 * @author t.shkolnik
 */
interface LocalDataSource {

    fun getShopList(): List<ShopItemDbModel>

    suspend fun getShopItem(shopItemId: Int): ShopItemDbModel?

    suspend fun addShopItem(shopItem: ShopItemDbModel)

    suspend fun deleteShopItem(shopItem: ShopItemDbModel)
}
