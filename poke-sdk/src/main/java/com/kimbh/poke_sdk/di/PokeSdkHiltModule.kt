package com.kimbh.poke_sdk.di

import com.kimbh.poke_data_remote.di.DataSourceModule
import com.kimbh.poke_data_remote.di.NetworkModule
import com.kimbh.poke_sdk_data.di.DataModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DataModule::class,
        DataSourceModule::class,
        NetworkModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object PokeSdkHiltModule