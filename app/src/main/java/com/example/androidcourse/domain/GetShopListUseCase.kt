package com.example.androidcourse.domain

/**
 * @author t.shkolnik
 */
class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    operator fun invoke(): List<ShopItem> {
        return shopListRepository.getShopList()
    }
}
