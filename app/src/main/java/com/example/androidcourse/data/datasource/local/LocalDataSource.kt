package com.example.androidcourse.data.datasource.local

import com.example.androidcourse.data.entity.ShopItemDbModel

/**
 * @author t.shkolnik
 */
interface LocalDataSource {

    fun getShopList(): List<ShopItemDbModel>

    fun getShopItem(shopItemId: Int): ShopItemDbModel?

    fun addShopItem(shopItem: ShopItemDbModel)

    fun editShopItem(shopItem: ShopItemDbModel)

    fun deleteShopItem(shopItem: ShopItemDbModel)
}
