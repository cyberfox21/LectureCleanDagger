package com.example.androidcourse.presentation.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcourse.presentation.ShopListItem

class ShopListAdapter : ListAdapter<DelegateItem, RecyclerView.ViewHolder>(ShopListDiffCallback()) {
//class ShopListAdapter : ListAdapter<ShopListItem, RecyclerView.ViewHolder>(ShopListDiffCallback()) {

    private val delegates = mutableListOf<AdapterDelegate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].onCreateViewHolder(parent)
//        return object : RecyclerView.ViewHolder(parent){
//
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegates[getItemViewType(position)].onBindViewHolder(
            holder,
            currentList[position],
            position
        )
    }

    override fun getItemViewType(position: Int): Int {
        return delegates.indexOfFirst { it.isOfViewType(currentList[position]) }
//        return 0
    }

//    fun addDelegate(delegateList: List<ShopListItem>) {
    fun addDelegate(delegateList: List<AdapterDelegate>) {
        delegateList.forEach {
            delegates.add(it)
        }
    }
}
