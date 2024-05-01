package com.example.androidcourse.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author t.shkolnik
 */
@Entity(tableName = "shop_items")
class ShopItemDbModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean,
)
