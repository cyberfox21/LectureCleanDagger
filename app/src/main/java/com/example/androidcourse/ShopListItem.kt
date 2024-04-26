package com.example.androidcourse

/**
 * @author t.shkolnik
 */
data class ShopListItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
