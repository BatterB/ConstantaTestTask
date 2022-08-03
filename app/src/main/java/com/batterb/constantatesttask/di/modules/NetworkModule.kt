package com.batterb.constantatesttask.di.modules

import com.batterb.constantatesttask.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideHomeApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Reusable
    fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}