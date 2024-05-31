package com.example.movieapp.domain.repository

import androidx.paging.PagingData
import com.example.movieapp.data.remote.dto.MovieDetailsDto
import com.example.movieapp.data.remote.dto.Result
import com.example.movieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieById(movie_id: String): MovieDetailsDto
}