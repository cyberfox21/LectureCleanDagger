package com.example.androidcourse.domain

import com.example.androidcourse.data.repository.ShopItemListRepository

/**
 * @author t.shkolnik
 */
//class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
class GetShopListUseCase(private val shopListRepository: ShopItemListRepository) {

    suspend operator fun invoke(): List<ShopItem> {
//        return shopListRepository.getShopList()
        return emptyList()
    }
}
