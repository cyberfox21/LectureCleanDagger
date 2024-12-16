package com.example.androidcourse.data.repository

import com.example.androidcourse.data.datasource.local.LocalDataSource
import com.example.androidcourse.data.datasource.remote.RemoteDataSource
import com.example.androidcourse.data.mapper.ShopItemDbModelMapper
import com.example.androidcourse.data.mapper.ShopItemDtoMapper
import com.example.androidcourse.domain.entity.ShopItem
import com.example.androidcourse.domain.repository.ShopListRepository
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class ShopListRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val shopItemDtoMapper: ShopItemDtoMapper,
    private val shopItemDbModelMapper: ShopItemDbModelMapper,
) : ShopListRepository {

    override suspend fun getShopItem(shopItemId: Int): ShopItem? {
        val local = localDataSource.getShopItem(shopItemId)
        return local?.let { shopItemDbModelMapper.map(it) }
            ?: remoteDataSource.getShopItem(shopItemId)?.let { shopItemDtoMapper.map(it) }
    }

    override suspend fun addShopItem(shopItem: ShopItem) {
        localDataSource.addShopItem(shopItemDbModelMapper.mapToShopItemDbModel(shopItem))
        remoteDataSource.addShopItem(
            shopItemId = shopItem.id.toString(),
            content = shopItemDtoMapper.mapToShopItemDtoString(shopItem),
        )
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        localDataSource.addShopItem(shopItemDbModelMapper.mapToShopItemDbModel(shopItem))
        remoteDataSource.editShopItem(
            shopItemId = shopItem.id.toString(),
            content = shopItemDtoMapper.mapToShopItemDtoString(shopItem)
        )
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        localDataSource.deleteShopItem(shopItemDbModelMapper.mapToShopItemDbModel(shopItem))
        remoteDataSource.deleteShopItem(
            shopItemId = shopItem.id.toString(),
            content = shopItemDtoMapper.mapToShopItemDtoString(shopItem)
        )
    }

    override suspend fun getShopList(): List<ShopItem> {
//        val local = localDataSource.getShopList()
//        return if (local.isEmpty()) {
//            remoteDataSource.getShopList().map { shopItemDtoMapper.map(it) }
//        } else local.map { shopItemDbModelMapper.map(it) }

        return listOf(
            ShopItem(
                id = 0,
                name = "Cалфетки",
                count = 3,
                enabled = true,
            ),
            ShopItem(
                id = 1,
                name = "Cметана",
                count = 1,
                enabled = true,
            ),
            ShopItem(
                id = 2,
                name = "Хлеб",
                count = 2,
                enabled = false,
            ),
            ShopItem(
                id = 3,
                name = "Шоколадка",
                count = 5,
                enabled = false,
            ),
            ShopItem(
                id = 4,
                name = "Молоко",
                count = 1,
                enabled = true,
            ),
            ShopItem(
                id = 5,
                name = "Помидоры",
                count = 2,
                enabled = false,
            )
        )
    }
}
