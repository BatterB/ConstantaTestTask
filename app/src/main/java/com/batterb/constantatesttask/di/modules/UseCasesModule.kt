package com.batterb.constantatesttask.di.modules

import com.batterb.constantatesttask.domain.repository.MovieRepository
import com.batterb.constantatesttask.domain.usecases.MovieUseCase
import com.batterb.constantatesttask.domain.usecases.MovieUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository) : MovieUseCase{
        return MovieUseCaseImpl(movieRepository)
    }
}