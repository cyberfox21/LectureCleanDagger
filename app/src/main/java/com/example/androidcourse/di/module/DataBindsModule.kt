package com.example.androidcourse.di.module

import com.example.androidcourse.data.datasource.local.LocalDataSource
import com.example.androidcourse.data.datasource.local.LocalDataSourceImpl
import com.example.androidcourse.data.datasource.remote.RemoteDataSource
import com.example.androidcourse.data.datasource.remote.RemoteDataSourceImpl
import com.example.androidcourse.data.repository.ShopListRepositoryImpl
import com.example.androidcourse.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module

/**
 * @author t.shkolnik
 */
@Module
interface DataBindsModule {

    @Binds
    fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    fun bindRepository(repositoryImpl: ShopListRepositoryImpl): ShopListRepository
}
