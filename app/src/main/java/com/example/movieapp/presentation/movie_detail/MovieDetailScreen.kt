package com.example.movieapp.presentation.movie_detail

import android.app.Service
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.R
import com.example.movieapp.common.Dimens.ScreenPadding1
import com.example.movieapp.common.Dimens.ScreenPadding2
import com.example.movieapp.common.Dimens.TextPadding1
import com.example.movieapp.common.Services
import com.example.movieapp.presentation.movie_detail.component.GenreItem
import com.example.movieapp.presentation.ui.theme.LightBlack

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 64.dp)
    ) {
        state.movie?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(context)
                        .data(state.movie.backdropPath).build(),
                    contentDescription = null
                )
                Row (
                  modifier = Modifier
                      .fillMaxWidth()
                      .wrapContentHeight()
                      .padding(ScreenPadding2),
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .width(128.dp)
                            .height(180.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop,
                        model = ImageRequest.Builder(context)
                            .data(state.movie.posterPath).build(),
                        contentDescription = null
                    )
                    Column (
                        modifier = Modifier
                            .padding(horizontal = TextPadding1, vertical = 8.dp),
                    ) {
                        Text(
                            text = state.movie.title,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Text(
                            text = "Release date : ${Services.date(state.movie.releaseDate)}",
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = "Duration : ${state.movie.runtime} minutes",
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = "Language : ${state.movie.originalLanguage}",
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        FlowRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                        ) {
                            state.movie.genres?.forEach {
                                GenreItem(genre = it.name)
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .padding(horizontal = ScreenPadding2)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = state.movie.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(horizontal = ScreenPadding2)
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = LightBlack),
                    modifier = Modifier
                        .width(236.dp)
                        .height(48.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = { },
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "Add to Watch List",
                            color = Color.White,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            }
        }
    }
}