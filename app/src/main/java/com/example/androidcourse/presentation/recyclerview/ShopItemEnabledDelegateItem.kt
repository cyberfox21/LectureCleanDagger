package com.example.androidcourse.presentation.recyclerview

import com.example.androidcourse.presentation.ShopListItem

/**
 * @author t.shkolnik
 */
class ShopItemEnabledDelegateItem(
    val name: String,
    val count: Int,
    var id: Int = ShopListItem.UNDEFINED_ID
) : DelegateItem {

    override fun id(): Any = id

    override fun content(): Any = name
}
