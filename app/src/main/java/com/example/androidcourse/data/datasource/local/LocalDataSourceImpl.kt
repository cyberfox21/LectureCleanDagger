package com.example.androidcourse.data.datasource.local

import com.example.androidcourse.data.entity.ShopItemDbModel
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class LocalDataSourceImpl @Inject constructor(
    private val dao: ShopItemDao
) : LocalDataSource {

    override fun getShopList(): List<ShopItemDbModel> {
        return dao.getShopList()
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItemDbModel? {
        return dao.getShopItem(shopItemId)
    }

    override suspend fun addShopItem(shopItem: ShopItemDbModel) {
        dao.addShopItem(shopItem)
    }

    override suspend fun deleteShopItem(shopItem: ShopItemDbModel) {
        dao.deleteShopItem(shopItem.id)
    }
}
