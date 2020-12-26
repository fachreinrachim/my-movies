package com.fachreinrachim.mymovies.repositories.movielist

import com.fachreinrachim.mymovies.data.response.MovieListResp
import com.fachreinrachim.mymovies.repositories.movielist.datasource.MovieListDataSource
import com.fachreinrachim.mymovies.repositories.movielist.datasource.MovieListRemoteDataSource

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
class MovieListRepositories {
    private var dataSource: MovieListDataSource? = null

    companion object {
        val INSTANCE by lazy { MovieListRepositories() }
    }

    fun init (dataSource: MovieListRemoteDataSource) {
        this.dataSource = dataSource
    }

    suspend fun getMovieListByGenre(
        genreId: String,
        page: Int
    ): MovieListResp? {
        return dataSource?.getMovieList(
            genreId, page
        )
    }
}