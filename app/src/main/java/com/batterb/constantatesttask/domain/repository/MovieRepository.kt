package com.batterb.constantatesttask.domain.repository

import com.batterb.constantatesttask.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieList() : List<Movie>
}