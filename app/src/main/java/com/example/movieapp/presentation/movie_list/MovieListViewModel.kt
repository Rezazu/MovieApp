package com.example.movieapp.presentation.movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.movieapp.domain.use_case.MoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val moviesUseCases: MoviesUseCases
): ViewModel() {

    val movies = moviesUseCases.getMovies().cachedIn(viewModelScope)
}