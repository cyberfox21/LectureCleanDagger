package com.example.androidcourse.domain.usecase

import com.example.androidcourse.domain.entity.ShopItem
import com.example.androidcourse.domain.repository.ShopListRepository
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class GetShopItemUseCase @Inject constructor(
    private val repository: ShopListRepository
) {

    suspend operator fun invoke(shopItemId: Int): ShopItem? {
        return repository.getShopItem(shopItemId)
    }
}
