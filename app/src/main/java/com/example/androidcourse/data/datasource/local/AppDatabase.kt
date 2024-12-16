package com.example.androidcourse.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidcourse.data.entity.ShopItemDbModel

/**
 * @author t.shkolnik
 */
@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun shopItemDao(): ShopItemDao
}
