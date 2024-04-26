package com.example.androidcourse

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.androidcourse.DelegateItem

/**
 * @author t.shkolnik
 */
class ShopListDiffCallback : DiffUtil.ItemCallback<DelegateItem>() {

    override fun areItemsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean {
        return oldItem::class == newItem::class && oldItem.id() == newItem.id()
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean {
        return oldItem.content() == newItem.content()
    }
}
