package com.example.androidcourse.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ShopListAdapter : ListAdapter<DelegateItem, RecyclerView.ViewHolder>(ShopListDiffCallback()) {

    private val delegates = mutableListOf<AdapterDelegate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].onCreateViewHolder(parent)
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
    }

    fun addDelegate(delegateList: List<AdapterDelegate>) {
        delegateList.forEach {
            delegates.add(it)
        }
    }
}
