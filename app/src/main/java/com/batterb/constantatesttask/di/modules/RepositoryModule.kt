package com.batterb.constantatesttask.di.modules

import com.batterb.constantatesttask.data.network.ApiService
import com.batterb.constantatesttask.data.repository.MovieRepositoryImpl
import com.batterb.constantatesttask.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideMovieRepository(apiService: ApiService) : MovieRepository {
        return MovieRepositoryImpl(apiService)
    }
}