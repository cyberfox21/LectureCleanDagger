package com.example.androidcourse.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcourse.domain.GetShopListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * @author t.shkolnik
 */
class ShopListViewModel(
    private val getShopList: GetShopListUseCase,
    private val mapper: ShopListItemMapper,
) : ViewModel() {

    private val _shopItems = MutableStateFlow<List<ShopListItem>>(emptyList())
    val shopItems: StateFlow<List<ShopListItem>> = _shopItems

    init {
        loadShopItems()
    }

    private fun loadShopItems() {
        viewModelScope.launch {
            _shopItems.value = getShopList().map { mapper.map(it) }
        }
    }
}
