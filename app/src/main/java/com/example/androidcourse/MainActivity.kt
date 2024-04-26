package com.example.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcourse.databinding.ActivityMainBinding

/**
 * @author t.shkolnik
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var shopListAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
        shopListAdapter.submitList(
            listOf(
                ShopItemEnabledDelegateItem(
                    name = "Cалфетки",
                    count = 3,
                ),
                ShopItemEnabledDelegateItem(
                    name = "Cметана",
                    count = 1,
                ),
                ShopItemDisabledDelegateItem(
                    name = "Хлеб",
                    count = 2,
                ),
                ShopItemDisabledDelegateItem(
                    name = "Шоколадка",
                    count = 5,
                ),
                ShopItemEnabledDelegateItem(
                    name = "Молоко",
                    count = 1,
                ),
                ShopItemDisabledDelegateItem(
                    name = "Помидоры",
                    count = 2,
                )
            )
        )
    }
}
