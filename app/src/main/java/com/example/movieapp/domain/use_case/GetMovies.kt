package com.example.movieapp.domain.use_case

import androidx.paging.PagingData
import com.example.movieapp.data.remote.dto.Result
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class GetMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<Movie>> {
        return movieRepository.getMovies()
    }


}