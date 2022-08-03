package com.batterb.constantatesttask.domain.usecases

import com.batterb.constantatesttask.domain.model.Movie
import com.batterb.constantatesttask.domain.repository.MovieRepository
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : MovieUseCase {

    override suspend fun getMovieList() : List<Movie>{
        val oldListMovies = movieRepository.getMovieList()
        val newListMovies = mutableListOf<Movie>()
        oldListMovies.forEach{
            val directorNameParts = it.directorName.split(" ")
            val directorName = "${directorNameParts[2]} " +
                    "${directorNameParts[0].substring(0,1)}.${directorNameParts[1].substring(0,1)}"

            val actors = it.actors.toSet().toList()

            newListMovies.add(Movie(it.title,directorName,it.releaseYear,actors))
        }
        return newListMovies.sortedWith(compareBy{it.releaseYear})
    }
}