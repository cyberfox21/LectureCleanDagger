package com.example.androidcourse.data.mapper

import com.example.androidcourse.data.entity.ShopItemDTO
import com.example.androidcourse.domain.ShopItem

/**
 * @author t.shkolnik
 */
class ShopItemDtoMapper {

    fun map(dto: ShopItemDTO): ShopItem {
        return with(dto){
            ShopItem(
                name = name ?: DEFAULT_NAME,
                count = count ?: DEFAULT_COUNT,
                enabled = true,
            )
        }
    }

    companion object {

        private const val DEFAULT_NAME = "NAME"
        private const val DEFAULT_COUNT = 3
    }
}
