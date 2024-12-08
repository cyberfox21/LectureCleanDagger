package com.example.androidcourse.domain.usecase

import com.example.androidcourse.domain.entity.ShopItem
import com.example.androidcourse.domain.repository.ShopListRepository

/**
 * @author t.shkolnik
 */
class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend operator fun invoke(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}
