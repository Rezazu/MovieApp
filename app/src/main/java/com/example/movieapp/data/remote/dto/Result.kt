package com.example.movieapp.data.remote.dto

import com.example.movieapp.domain.model.Movie
import kotlin.Result

data class Result(
    val adult: Boolean,
    val backdropPath: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
//val adult: Boolean,
//val genreIds: List<Int>,
//val id: Int,
//val originalLanguage: String,
//val originalTitle: String,
//val overview: String,
//val posterPath: String,
//val releaseDate: String,

fun com.example.movieapp.data.remote.dto.Result.toMovies(): Movie {
    return Movie(
        adult = adult,
        genreIds = genre_ids,
        id = id,
        originalLanguage = original_language,
        originalTitle = original_title,
        posterPath = poster_path,
        releaseDate = release_date,
        title = title
    )
}