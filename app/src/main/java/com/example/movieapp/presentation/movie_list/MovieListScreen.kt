package com.example.movieapp.presentation.movie_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
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
import com.example.movieapp.common.Dimens.ScreenPadding1
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.Screen

@Composable
fun MovieListScreen(
    movies: LazyPagingItems<Movie>,
    navController: NavController,
) {
    val categoryItem = listOf("Now Playing", "Popular")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(ScreenPadding1)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                categoryItem.forEach { item ->
                    CategoryCard(category = item)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(count = movies.itemCount) { it ->
                    movies[it]?.let { movie ->
                        MovieCard(
                            movie = movie,
                            onItemClick = { navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}")}
                        )
                    }
                }
            }
        }
    }

}