package com.example.movieapp.presentation

sealed class Screen (
    val route: String
) {
    object MovieListScreen: Screen("movie_list_screen")
}