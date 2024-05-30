package com.example.movieapp.data.remote.dto

import com.example.movieapp.domain.model.Movie
import kotlin.Result

data class Result(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
//val adult: Boolean,
//val genreIds: List<Int>,
//val id: Int,
//val originalLanguage: String,
//val originalTitle: String,
//val overview: String,
//val posterPath: String,
//val releaseDate: String,

fun com.example.movieapp.data.remote.dto.Result.toMovie(): Movie {
    return Movie(
        adult = adult,
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        posterPath = posterPath,
        releaseDate = releaseDate
    )
}