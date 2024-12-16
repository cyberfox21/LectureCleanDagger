package com.example.androidcourse.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcourse.domain.usecase.GetShopListUseCase
import com.example.androidcourse.presentation.recyclerview.DelegateItem
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class ShopListViewModel @Inject constructor(
    private val getShopList: GetShopListUseCase,
    private val mapper: ShopListItemMapper,
) : ViewModel() {

    private val _shopItems = MutableStateFlow<List<DelegateItem>>(emptyList())
    val shopItems: StateFlow<List<DelegateItem>> = _shopItems

    private val _errorChannel: Channel<Unit> = Channel(Channel.BUFFERED)
    val errorChannel: Flow<Unit> = _errorChannel.receiveAsFlow()

    init {
        loadShopItems()
    }

    private fun loadShopItems() {
        viewModelScope.launch {
            _shopItems.value = getShopList().map { mapper.map(it) }
        }
    }
}
