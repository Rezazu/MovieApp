package com.example.movieapp.presentation.movie_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        state.movie?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(516.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(context)
                        .data(state.movie.posterPath).build(),
                    contentDescription = null
                )
                Text(
                    text = state.movie.title,
                    style = MaterialTheme.typography.displayMedium,
                )
                Text(
                    text = state.movie.releaseDate,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = "${state.movie.runtime} minutes",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}