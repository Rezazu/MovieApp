package com.example.movieapp.presentation.movie_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun MovieCard(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {
    val context = LocalContext.current
    
    Card(
        modifier = Modifier
            .height(260.dp)
            .width(180.dp)
            .clickable { onItemClick(movie) },
        shape = RoundedCornerShape(15.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
                model = ImageRequest
                    .Builder(context)
                    .data(movie.posterPath)
                    .build(),
                contentDescription = null
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMovieCard(modifier: Modifier = Modifier) {
    MovieAppTheme {
        MovieCard(
            movie =
                Movie(
                    adult = true,
                    genreIds = listOf(1,2,3),
                    id = 1,
                    originalLanguage = "En",
                    originalTitle = "Avengers",
                    posterPath = "https://image.tmdb.org/t/p/original//gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                    releaseDate = "2012-01-02",
                    title = "Avengers"
                )
        ) {

        }
    }
}