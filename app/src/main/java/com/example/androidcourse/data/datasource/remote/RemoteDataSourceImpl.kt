package com.example.androidcourse.data.datasource.remote

import com.example.androidcourse.data.entity.ShopItemDTO
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class RemoteDataSourceImpl @Inject constructor(
    private val api: ApiService
) : RemoteDataSource {

    override suspend fun getShopList(): List<ShopItemDTO> {
        return api.getShopList()
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItemDTO? {
        return api.getShopItem(shopItemId.toString())
    }

    override suspend fun addShopItem(shopItemId: String, content: String) {
        api.addShopItem(shopItemId, content)
    }

    override suspend fun editShopItem(shopItemId: String, content: String) {
        api.editShopItem(shopItemId, content)
    }

    override suspend fun deleteShopItem(shopItemId: String, content: String) {
        api.deleteShopItem(shopItemId, content)
    }
}
