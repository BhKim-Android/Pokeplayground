package com.kimbh.poke_data_remote.di

import com.google.gson.GsonBuilder
import com.kimbh.poke_data_remote.api.PokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient {
        // HTTP 요청/응답을 로깅하는 인터셉터
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            // 디버그 빌드에서만 BODY 레벨의 로그를 출력하도록 설정
//            level = if (BuildConfig.DEBUG) {
//                HttpLoggingInterceptor.Level.BODY
//            } else {
            HttpLoggingInterceptor.Level.NONE
//            }
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // 로깅 인터셉터 추가
            .connectTimeout(30, TimeUnit.SECONDS) // 연결 타임아웃
            .readTimeout(30, TimeUnit.SECONDS)    // 읽기 타임아웃
            .writeTimeout(30, TimeUnit.SECONDS)   // 쓰기 타임아웃
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .client(okHttpClient) // 위에서 만든 OkHttpClient를 사용
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            ) // Gson 컨버터 추가
            .build()
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): PokeApiService {
        // Retrofit 객체로 ApiService 인터페이스의 구현체를 생성
        return retrofit.create(PokeApiService::class.java)
    }
}