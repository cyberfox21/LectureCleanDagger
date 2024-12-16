package com.example.androidcourse.domain.usecase

import com.example.androidcourse.domain.entity.ShopItem
import com.example.androidcourse.domain.repository.ShopListRepository
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class GetShopListUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {

    suspend operator fun invoke(): List<ShopItem> {
        return shopListRepository.getShopList()
    }
}
