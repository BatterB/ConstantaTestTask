package com.batterb.constantatesttask.di.modules

import com.batterb.constantatesttask.presentation.movielist.MovieAdapter
import dagger.Module
import dagger.Provides

@Module
class RecyclerViewModule {
    @Provides
    fun provideMoviesAdapter() : MovieAdapter{
        return MovieAdapter()
    }
}