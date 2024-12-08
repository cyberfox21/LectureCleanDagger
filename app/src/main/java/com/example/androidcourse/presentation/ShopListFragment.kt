package com.example.androidcourse.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidcourse.data.repository.ShopItemListRepository
import com.example.androidcourse.databinding.FragmentShopListBinding
import com.example.androidcourse.domain.usecase.GetShopListUseCase
import com.example.androidcourse.presentation.recyclerview.ShopListAdapter
import kotlinx.coroutines.launch

/**
 * @author t.shkolnik
 */
class ShopListFragment : Fragment() {

    private var _binding: FragmentShopListBinding? = null
    private val binding get() = requireNotNull(_binding) { "_binding is null" }

    private lateinit var shopListAdapter: ShopListAdapter

    private val repository = ShopItemListRepository()
    private val getShopListUseCase = GetShopListUseCase(repository)

    private val mapper = ShopListItemMapper()

    private val viewModel = ViewModelProvider(
        this,
        ShopListViewModelFactory(getShopListUseCase, mapper),
    )[ShopListViewModel::class.java]

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
        observeData()
    }

    private fun setupRecyclerView() {
        with(binding.rvShopList) {
            shopListAdapter = ShopListAdapter()
            adapter = shopListAdapter
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.shopItems.collect {
                shopListAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
