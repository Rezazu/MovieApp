package com.example.movieapp.presentation.movie_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun MovieCard(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = movie.title,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = movie.releaseDate.toString(),
            color = Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
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
                    posterPath = "",
                    releaseDate = "2012-01-02",
                    title = "Avengers"
                )
        ) {

        }
    }
}