package com.example.androidcourse.domain

/**
 * @author t.shkolnik
 */
data class ShopItem(
    val name: String,
    val count: Int,
    var id: Int = UNDEFINED_ID,
    val enabled: Boolean,
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
