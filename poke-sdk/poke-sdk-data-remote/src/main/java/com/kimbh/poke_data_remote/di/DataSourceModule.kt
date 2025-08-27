package com.kimbh.poke_data_remote.di

import com.kimbh.poke_data_remote.DataSourceImpl
import com.kimbh.poke_sdk_data.datasource.DataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindDataSource(dataSourceImpl: DataSourceImpl): DataSource
}