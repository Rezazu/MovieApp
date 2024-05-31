package com.example.movieapp.domain.model

data class Movie(
    val adult: Boolean,
    val genreIds: List<Int>?,
    val id: Int,
    val originalLanguage: String?,
    val originalTitle: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String,
)
