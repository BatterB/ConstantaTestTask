package com.batterb.constantatesttask.domain.usecases

import com.batterb.constantatesttask.domain.model.Movie

interface MovieUseCase {
    suspend fun getMovieList() : List<Movie>
}