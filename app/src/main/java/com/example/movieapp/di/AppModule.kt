package com.example.movieapp.di

import com.example.movieapp.common.Constant.BASE_URL
import com.example.movieapp.data.remote.MovieApi
import com.example.movieapp.data.repository.MovieRepositoryImpl
import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.use_case.GetMovieById
import com.example.movieapp.domain.use_case.GetMovies
import com.example.movieapp.domain.use_case.MoviesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideMovieUseCases(
        movieRepository: MovieRepository
    ): MoviesUseCases {
        return MoviesUseCases(
            getMovies = GetMovies(movieRepository),
            getMovieById = GetMovieById(movieRepository),
        )
    }
}