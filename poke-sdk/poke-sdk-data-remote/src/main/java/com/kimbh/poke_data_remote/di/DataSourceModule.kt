package com.kimbh.poke_data_remote.di

import com.kimbh.poke_data_remote.PokeRemoteDataSourceImpl
import com.kimbh.poke_sdk_data.datasource.PokeRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindDataSource(pokeRemoteDataSourceImpl: PokeRemoteDataSourceImpl): PokeRemoteDataSource
}