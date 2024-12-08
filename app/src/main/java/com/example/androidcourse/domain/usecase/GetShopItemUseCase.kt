package com.example.androidcourse.domain.usecase

import com.example.androidcourse.domain.entity.ShopItem
import com.example.androidcourse.domain.repository.ShopListRepository

/**
 * @author t.shkolnik
 */
class GetShopItemUseCase(private val repository: ShopListRepository) {

    suspend operator fun invoke(shopItemId: Int): ShopItem? {
        return repository.getShopItem(shopItemId)
    }
}
