package com.example.movieapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSourceFactory
import com.example.movieapp.data.remote.MovieApi
import com.example.movieapp.data.remote.MoviePaging
import com.example.movieapp.data.remote.dto.MovieDetailsDto
import com.example.movieapp.data.remote.dto.Result
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
): MovieRepository {
    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                MoviePaging(
                    movieApi = movieApi,
                )
            }
        ).flow
    }

    override suspend fun getMovieById(movie_id: String): MovieDetailsDto {
        return movieApi.getMovieById(movie_id = movie_id)
    }
}