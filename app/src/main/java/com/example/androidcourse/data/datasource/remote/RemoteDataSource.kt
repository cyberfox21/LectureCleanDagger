package com.example.androidcourse.data.datasource.remote

import com.example.androidcourse.data.entity.ShopItemDTO

/**
 * @author t.shkolnik
 */
interface RemoteDataSource {

    fun getShopList(): List<ShopItemDTO>

    fun getShopItem(shopItemId: Int): ShopItemDTO?

    fun addShopItem(shopItem: ShopItemDTO)

    fun editShopItem(shopItem: ShopItemDTO)

    fun deleteShopItem(shopItem: ShopItemDTO)
}
