package com.example.androidcourse.presentation.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidcourse.databinding.FragmentShopListBinding

/**
 * @author t.shkolnik
 */
class ShopListFragment : Fragment() {

    private var _binding: FragmentShopListBinding? = null
    private val binding get() = _binding!!

    private lateinit var shopListAdapter: ShopListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
