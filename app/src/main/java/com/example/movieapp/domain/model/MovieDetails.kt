package com.example.movieapp.domain.model

import com.example.movieapp.data.remote.dto.Genre
import com.example.movieapp.data.remote.dto.ProductionCompany
import com.example.movieapp.data.remote.dto.ProductionCountry
import com.example.movieapp.data.remote.dto.SpokenLanguage

data class MovieDetails(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
//    val productionCompanies: List<ProductionCompany>,
    val releaseDate: String,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)
