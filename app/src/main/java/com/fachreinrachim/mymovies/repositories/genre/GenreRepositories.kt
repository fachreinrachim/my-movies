package com.fachreinrachim.mymovies.repositories.genre

import com.fachreinrachim.mymovies.data.response.MovieGenresResp
import com.fachreinrachim.mymovies.repositories.genre.datasource.GenreDataSource
import com.fachreinrachim.mymovies.repositories.genre.datasource.GenreRemoteDataSource

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
class GenreRepositories {
    private var dataSource: GenreDataSource? = null

    companion object {
        val INSTANCE by lazy { GenreRepositories() }
    }

    fun init (dataSource: GenreRemoteDataSource) {
        this.dataSource = dataSource
    }

    suspend fun getMovieGenres(): MovieGenresResp? {
        return dataSource?.getMovieGenres()
    }
}