package com.example.androidcourse.domain

/**
 * @author t.shkolnik
 */
class GetShopItemUseCase(private val repository: ShopListRepository) {

    operator fun invoke(shopItemId: Int): ShopItem? {
        return repository.getShopItem(shopItemId)
    }
}
