package com.example.androidcourse.di.module

import com.example.androidcourse.data.repository.ShopListRepositoryImpl
import com.example.androidcourse.domain.repository.ShopListRepository
import com.example.androidcourse.domain.usecase.AddShopItemUseCase
import com.example.androidcourse.domain.usecase.GetShopListUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * @author t.shkolnik
 */
@Module
class DomainModule {

    @Provides
    fun provideGetShopListUseCase(repository: ShopListRepository): GetShopListUseCase {
        return GetShopListUseCase(repository)
    }

    @Provides
    fun provideAddShopItemUseCase(repository: ShopListRepository): AddShopItemUseCase {
        return AddShopItemUseCase(repository)
    }
}
