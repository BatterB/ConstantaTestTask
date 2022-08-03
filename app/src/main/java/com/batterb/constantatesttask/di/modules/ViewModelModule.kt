package com.batterb.constantatesttask.di.modules

import android.content.Context
import com.batterb.constantatesttask.domain.usecases.MovieUseCase
import com.batterb.constantatesttask.presentation.movielist.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(private val context: Context) {
    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideMoviesViewModel(moviesUseCaseImpl: MovieUseCase) : MovieViewModelFactory{
        return MovieViewModelFactory(moviesUseCaseImpl)
    }
}