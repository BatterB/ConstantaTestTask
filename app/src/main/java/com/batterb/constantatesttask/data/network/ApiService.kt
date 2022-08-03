package com.batterb.constantatesttask.data.network

import com.batterb.constantatesttask.data.dto.MovieListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("./constanta-android-dev/intership-wellcome-task/main/films.json")
    suspend fun getMoviesList() : MovieListResponse
}