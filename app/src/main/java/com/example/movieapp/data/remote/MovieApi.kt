package com.example.movieapp.data.remote

import com.example.movieapp.common.Constant.API_KEY
import com.example.movieapp.data.remote.dto.MovieDetailsDto
import com.example.movieapp.data.remote.dto.MovieDto
import com.example.movieapp.domain.model.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/now_playing")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDto

    @GET ("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movie_id: String,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDetailsDto
}