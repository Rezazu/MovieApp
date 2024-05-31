package com.example.movieapp.presentation.movie_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import com.example.movieapp.domain.model.Movie

@Composable
fun MovieListScreen(
    movies: LazyPagingItems<Movie>,
//    navigate: (String) -> Unit,
    navController: NavController,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Movie List")
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn (
           modifier = Modifier
               .fillMaxSize()
        ) {
            items(count = movies.itemCount) { it ->
                movies[it]?.let {
                    MovieCard(
                        movie = it,
                        onItemClick = {}
                    )
                }
            }
        }
    }

}