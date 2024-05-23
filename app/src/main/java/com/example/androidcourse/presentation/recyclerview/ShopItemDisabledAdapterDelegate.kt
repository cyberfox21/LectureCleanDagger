package com.example.androidcourse.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcourse.databinding.ItemShopDisabledBinding
import com.example.androidcourse.presentation.OnLongShopItemClickListener
import com.example.androidcourse.presentation.OnShopItemClickListener

/**
 * @author t.shkolnik
 */
class ShopItemDisabledAdapterDelegate(
    private val onLongShopItemClickListener: OnLongShopItemClickListener,
    private val onShopItemClickListener: OnShopItemClickListener,
) : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ShopItemDisabledViewHolder(
            ItemShopDisabledBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        val shopItem = item as ShopItemDisabledDelegateItem
        val binding = (holder as ShopItemDisabledViewHolder).binding

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

    override fun isOfViewType(item: DelegateItem): Boolean = item is ShopItemDisabledDelegateItem
}
