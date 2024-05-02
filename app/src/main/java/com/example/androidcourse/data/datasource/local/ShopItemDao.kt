package com.example.androidcourse.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidcourse.data.entity.ShopItemDbModel

/**
 * @author t.shkolnik
 */
@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_items")
    fun getShopList(): List<ShopItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItem(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM shop_items WHERE id = :id")
    suspend fun deleteShopItem(id: Int)

    @Query("SELECT * FROM shop_items WHERE id = :id LIMIT 1")
    suspend fun getShopItem(id: Int): ShopItemDbModel?
}
