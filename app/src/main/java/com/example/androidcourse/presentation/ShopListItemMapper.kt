package com.example.androidcourse.presentation

import com.example.androidcourse.domain.ShopItem

/**
 * @author t.shkolnik
 */
class ShopListItemMapper {

    fun map(item: ShopItem): ShopListItem {
        return with(item) {
            ShopListItem(
                name = name,
                count = count,
                enabled = enabled,
                id = id,
            )
        }
    }
}
