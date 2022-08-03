package com.batterb.constantatesttask.data.dto

import com.batterb.constantatesttask.domain.model.Movie

data class MovieDto (
    val title : String,
    val directorName : String,
    val releaseYear : Int,
    val actors : List<Actor>
    )

data class Actor(val actorName : String)

fun List<MovieDto>.asDomainModel () : List<Movie>{
    return map{ movie ->
        Movie(
            title = movie.title,
            directorName = movie.directorName,
            releaseYear = movie.releaseYear,
            actors = movie.actors.map { it.actorName }
        )
    }
}