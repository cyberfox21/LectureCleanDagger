package com.example.androidcourse.domain

/**
 * @author t.shkolnik
 */
class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend operator fun invoke(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}
