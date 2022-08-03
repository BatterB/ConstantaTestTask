package com.batterb.constantatesttask.data.dto

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
        @SerializedName("items")
        val movieList : List<MovieDto>
)