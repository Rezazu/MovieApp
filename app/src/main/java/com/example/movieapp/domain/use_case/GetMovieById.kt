package com.example.movieapp.domain.use_case

import com.example.movieapp.common.Resource
import com.example.movieapp.data.remote.dto.toMovieDetails
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.model.MovieDetails
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetMovieById(
    private val repository: MovieRepository
) {
    operator fun invoke(movie_id: String): kotlinx.coroutines.flow.Flow<Resource<MovieDetails>> = flow {
        try {
            emit(Resource.Loading<MovieDetails>())
            val movie = repository.getMovieById(movie_id).toMovieDetails()
            emit(Resource.Success<MovieDetails>(movie))
        } catch (e: HttpException) {
            emit(Resource.Error<MovieDetails>(e.localizedMessage ?: "An unexpected error, but a welcome one"))
        } catch (e: IOException) {
            emit(Resource.Error<MovieDetails>("So unicivilized (No Connection!)"))
        }
    }
}