package com.example.openweathermapkotlin.di

import com.example.openweathermapkotlin.network.ApiService
import com.example.openweathermapkotlin.utils.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInit(): Retrofit{
        return Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return provideRetrofitInit().create(ApiService::class.java)
    }
}