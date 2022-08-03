package com.batterb.constantatesttask.domain.model

data class Movie (
    val title : String,
    val directorName : String,
    val releaseYear : Int,
    val actors : List<String>
)