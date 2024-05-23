package com.example.androidcourse.domain

/**
 * @author t.shkolnik
 */
class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend operator fun invoke(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}
