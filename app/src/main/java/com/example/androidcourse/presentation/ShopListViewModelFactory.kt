package com.example.androidcourse.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcourse.domain.GetShopListUseCase

/**
 * @author t.shkolnik
 */
class ShopListViewModelFactory(
    private val getShopListUseCase: GetShopListUseCase,
    private val mapper: ShopListItemMapper,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopListViewModel::class.java)) {
            return ShopListViewModel(
                getShopList = getShopListUseCase,
                mapper = mapper
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
