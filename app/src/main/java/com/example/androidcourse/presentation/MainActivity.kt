package com.example.androidcourse.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidcourse.MyApp
import com.example.androidcourse.databinding.ActivityMainBinding
import com.example.androidcourse.presentation.recyclerview.ShopItemDisabledAdapterDelegate
import com.example.androidcourse.presentation.recyclerview.ShopItemDisabledDelegateItem
import com.example.androidcourse.presentation.recyclerview.ShopItemEnabledAdapterDelegate
import com.example.androidcourse.presentation.recyclerview.ShopItemEnabledDelegateItem
import com.example.androidcourse.presentation.recyclerview.ShopListAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author t.shkolnik
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var shopListAdapter: ShopListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ShopListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApp).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory)[ShopListViewModel::class.java]
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        with(binding.rvShopList) {
            shopListAdapter = ShopListAdapter()
            shopListAdapter.addDelegate(
                listOf(
                    ShopItemEnabledAdapterDelegate(
                        onShopItemClickListener = {},
                        onLongShopItemClickListener = {},
                    ),
                    ShopItemDisabledAdapterDelegate(
                        onShopItemClickListener = {},
                        onLongShopItemClickListener = {},
                    ),
                )
            )
            adapter = shopListAdapter
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.shopItems.collect { items ->
                shopListAdapter.submitList(items)
            }
        }
    }
}
