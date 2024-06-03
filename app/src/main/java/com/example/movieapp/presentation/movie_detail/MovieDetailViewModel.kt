package com.example.movieapp.presentation.movie_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.common.Constant.PARAM_MOVIE_ID
import com.example.movieapp.common.Resource
import com.example.movieapp.domain.model.MovieDetails
import com.example.movieapp.domain.use_case.GetMovieById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieByIdUseCase: GetMovieById,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_MOVIE_ID)?.let { movie_id ->
            getMovie(movie_id)
        }
    }

    private fun getMovie(movie_id: String) {
        getMovieByIdUseCase(movie_id).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = result.data)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailState(error = result.message ?:
                    "An unexpected error, but a welcome one")
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class MovieDetailState (
    val isLoading: Boolean = false,
    val movie: MovieDetails? = null,
    val error: String = ""
)