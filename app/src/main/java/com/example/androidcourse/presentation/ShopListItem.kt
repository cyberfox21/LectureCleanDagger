package com.example.androidcourse.presentation

/**
 * @author t.shkolnik
 */
data class ShopListItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    val id: Int = UNDEFINED_ID
) {

    companion object {
        const val UNDEFINED_ID = 0
    }
}
