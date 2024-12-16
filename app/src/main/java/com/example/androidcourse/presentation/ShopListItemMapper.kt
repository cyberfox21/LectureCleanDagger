package com.example.androidcourse.presentation

import com.example.androidcourse.domain.entity.ShopItem
import com.example.androidcourse.presentation.recyclerview.DelegateItem
import com.example.androidcourse.presentation.recyclerview.ShopItemDisabledDelegateItem
import com.example.androidcourse.presentation.recyclerview.ShopItemEnabledDelegateItem
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class ShopListItemMapper @Inject constructor() {

    fun map(item: ShopItem): DelegateItem {
        return with(item) {
            if (item.enabled) {
                ShopItemEnabledDelegateItem(
                    name = name,
                    count = count,
                    id = id,
                )
            } else {
                ShopItemDisabledDelegateItem(
                    name = name,
                    count = count,
                    id = id,
                )
            }
        }
    }
}
