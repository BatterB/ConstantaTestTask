package com.batterb.constantatesttask.data.repository

import com.batterb.constantatesttask.data.dto.asDomainModel
import com.batterb.constantatesttask.data.network.ApiService
import com.batterb.constantatesttask.domain.model.Movie
import com.batterb.constantatesttask.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {
    override suspend fun getMovieList() : List<Movie> {
        return apiService.getMoviesList().movieList.asDomainModel()
    }

}