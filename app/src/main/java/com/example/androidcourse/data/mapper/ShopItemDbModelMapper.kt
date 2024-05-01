package com.example.androidcourse.data.mapper

import com.example.androidcourse.data.entity.ShopItemDbModel
import com.example.androidcourse.domain.ShopItem

/**
 * @author t.shkolnik
 */
class ShopItemDbModelMapper {

    fun map(dbModel: ShopItemDbModel): ShopItem {
        return with(dbModel) {
            ShopItem(
                id = id,
                name = name,
                count = count,
                enabled = enabled,
            )
        }
    }
}
