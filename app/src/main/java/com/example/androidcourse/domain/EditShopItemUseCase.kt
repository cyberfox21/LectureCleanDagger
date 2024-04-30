package com.example.androidcourse.domain

/**
 * @author t.shkolnik
 */
class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    operator fun invoke(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}
