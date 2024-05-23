package com.example.androidcourse.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcourse.databinding.ItemShopEnabledBinding
import com.example.androidcourse.presentation.OnLongShopItemClickListener
import com.example.androidcourse.presentation.OnShopItemClickListener

/**
 * @author t.shkolnik
 */
class ShopItemEnabledAdapterDelegate(
    private val onLongShopItemClickListener: OnLongShopItemClickListener,
    private val onShopItemClickListener: OnShopItemClickListener,
) : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ShopItemEnabledViewHolder(
            ItemShopEnabledBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        val shopItem = item as ShopItemEnabledDelegateItem
        val binding = (holder as ShopItemEnabledViewHolder).binding

        binding.tvName.text = shopItem.name
        binding.tvCount.text = shopItem.count.toString()

//        binding.root.setOnLongClickListener {
//            onLongShopItemClickListener(shopItem)
//            true
//        }
//        binding.root.setOnClickListener {
//            onShopItemClickListener(shopItem)
//        }
    }

    override fun isOfViewType(item: DelegateItem): Boolean = item is ShopItemEnabledDelegateItem
}
