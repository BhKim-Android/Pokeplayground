package com.kimbh.poke_sdk_data.di

import com.kimbh.poke_sdk_data.PokeRepositoryImpl
import com.kimbh.poke_sdk_domain.repository.PokeRepository
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
    abstract fun bindPokeRepository(
        pokeRepositoryImpl: PokeRepositoryImpl
    ): PokeRepository
}