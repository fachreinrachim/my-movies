package com.fachreinrachim.mymovies.repositories.movie

import com.fachreinrachim.mymovies.data.models.Movies
import com.fachreinrachim.mymovies.data.response.MovieListResp
import com.fachreinrachim.mymovies.repositories.movie.datasource.MovieDataSource
import com.fachreinrachim.mymovies.repositories.movie.datasource.MovieRemoteDataSource
import com.fachreinrachim.mymovies.repositories.movielist.MovieListRepositories
import com.fachreinrachim.mymovies.repositories.movielist.datasource.MovieListDataSource
import com.fachreinrachim.mymovies.repositories.movielist.datasource.MovieListRemoteDataSource

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
class MovieRepositories {
    private var dataSource: MovieDataSource? = null

    companion object {
        val INSTANCE by lazy { MovieRepositories() }
    }

    fun init (dataSource: MovieRemoteDataSource) {
        this.dataSource = dataSource
    }

    suspend fun getMovieById(
        movieId: String
    ): Movies? {
        return dataSource?.getMovie(
            movieId
        )
    }
}