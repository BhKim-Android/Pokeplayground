package com.kimbh.poke_sdk_data.di

import com.kimbh.poke_sdk_data.repository.DetailRepositoryImpl
import com.kimbh.poke_sdk_data.repository.ListRepositoryImpl
import com.kimbh.poke_sdk_data.repository.SpeciesRepositoryImpl
import com.kimbh.poke_sdk_domain.repository.DetailRepository
import com.kimbh.poke_sdk_domain.repository.ListRepository
import com.kimbh.poke_sdk_domain.repository.SpeciesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindListRepository(
        listRepositoryImpl: ListRepositoryImpl
    ): ListRepository

    @Binds
    @Singleton
    abstract fun bindDetailRepository(
        detailRepositoryImpl: DetailRepositoryImpl
    ): DetailRepository

    @Binds
    @Singleton
    abstract fun bindSpeciesRepository(
        speciesRepositoryImpl: SpeciesRepositoryImpl
    ): SpeciesRepository
}