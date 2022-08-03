package com.batterb.constantatesttask.presentation.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.batterb.constantatesttask.domain.model.Movie
import com.batterb.constantatesttask.domain.usecases.MovieUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList : LiveData<List<Movie>>
        get() = _movieList

    fun loadMovies(){
        viewModelScope.launch {
            _movieList.value = movieUseCase.getMovieList()
        }
    }
}