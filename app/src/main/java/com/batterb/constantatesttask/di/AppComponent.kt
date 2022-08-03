package com.batterb.constantatesttask.di

import com.batterb.constantatesttask.data.dto.MovieListResponse
import com.batterb.constantatesttask.di.modules.*
import com.batterb.constantatesttask.presentation.movielist.MovieFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class,RecyclerViewModule::class,UseCasesModule::class,
        NetworkModule::class,RepositoryModule::class]
)
interface AppComponent {
    fun inject(movieFragment: MovieFragment)
}