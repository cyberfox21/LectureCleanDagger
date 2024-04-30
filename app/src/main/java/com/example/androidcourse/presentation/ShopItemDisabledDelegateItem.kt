package com.example.androidcourse.presentation

/**
 * @author t.shkolnik
 */
class ShopItemDisabledDelegateItem (
    val name: String,
    val count: Int,
    var id: Int = ShopListItem.UNDEFINED_ID
) : DelegateItem {

    override fun id(): Any = id

    override fun content(): Any = name
}
