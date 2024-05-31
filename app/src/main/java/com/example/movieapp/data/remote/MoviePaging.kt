package com.example.movieapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieapp.data.remote.dto.toMovies
import com.example.movieapp.domain.model.Movie

class MoviePaging (
    private val movieApi: MovieApi
): PagingSource <Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalMovieCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        return try {
            val movieDto = movieApi.getMovies()
            totalMovieCount += movieDto.results.size
            val movies = movieDto.results.distinctBy { it.title }
            LoadResult.Page (
                data = movies.map { it.toMovies() },
                nextKey = if (totalMovieCount == movieDto.total_results) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable =  e
            )
        }
    }
}