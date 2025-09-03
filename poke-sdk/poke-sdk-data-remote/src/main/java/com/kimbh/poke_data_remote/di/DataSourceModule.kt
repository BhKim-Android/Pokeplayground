package com.kimbh.poke_data_remote.di

import com.kimbh.poke_data_remote.datasource.DetailRemoteDataSourceImpl
import com.kimbh.poke_data_remote.datasource.ListRemoteDataSourceImpl
import com.kimbh.poke_data_remote.datasource.SpeciesRemoteDataSourceImpl
import com.kimbh.poke_sdk_data.datasource.DetailRemoteDataSource
import com.kimbh.poke_sdk_data.datasource.ListRemoteDataSource
import com.kimbh.poke_sdk_data.datasource.SpeciesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindDataSource(listRemoteDataSourceImpl: ListRemoteDataSourceImpl): ListRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindDetailRemoteDataSource(detailRemoteDataSourceImpl: DetailRemoteDataSourceImpl): DetailRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindSpeciesRemoteDataSource(speciesRemoteDataSourceImpl: SpeciesRemoteDataSourceImpl): SpeciesRemoteDataSource
}