package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.movieapp.presentation.Screen
import com.example.movieapp.presentation.movie_detail.MovieDetailScreen
import com.example.movieapp.presentation.movie_list.MovieListScreen
import com.example.movieapp.presentation.movie_list.MovieListViewModel
import com.example.movieapp.presentation.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MovieListScreen.route
                    ) {
                        composable(
                            route = Screen.MovieListScreen.route
                        ) {
                            val viewModel: MovieListViewModel = hiltViewModel()
                            val movies = viewModel.movies.collectAsLazyPagingItems()
                            MovieListScreen(movies, navController)
                        }
                        composable(
                            route = Screen.MovieDetailScreen.route + "/{movie_id}"
                        ) {
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
