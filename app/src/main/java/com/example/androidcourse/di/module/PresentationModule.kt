package com.example.androidcourse.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcourse.di.ViewModelKey
import com.example.androidcourse.presentation.ShopListViewModel
import com.example.androidcourse.presentation.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author t.shkolnik
 */
@Module
interface PresentationModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ShopListViewModel::class)
    fun bindShopListViewModel(viewModel: ShopListViewModel): ViewModel
}
