package com.example.movieapp.presentation.movie_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.presentation.ui.theme.LightBlue
import com.example.movieapp.presentation.ui.theme.LighterBlue
import com.example.movieapp.presentation.ui.theme.MovieAppTheme

@Composable
fun GenreItem(
    modifier: Modifier = Modifier,
    genre: String
) {
    Box(
        modifier = modifier
            .height(26.dp)
            .wrapContentWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(
                2.dp,
                color = Color.Black,
                RoundedCornerShape(20.dp)
            )
            .background(color = Color.White)
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = genre,
            style = MaterialTheme.typography.labelSmall,
            fontSize = 8.sp,
            color = Color.Black,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun PreviewGenreItem() {
    MovieAppTheme {
        GenreItem(genre = "Mystery")
    }
}