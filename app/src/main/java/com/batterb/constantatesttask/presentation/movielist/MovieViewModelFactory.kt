package com.batterb.constantatesttask.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.batterb.constantatesttask.domain.usecases.MovieUseCase
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor (
    private val movieUseCase: MovieUseCase
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(movieUseCase) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}