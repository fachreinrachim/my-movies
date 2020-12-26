package com.fachreinrachim.mymovies.repositories.movielist.datasource

import com.fachreinrachim.mymovies.data.response.MovieListResp


/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
interface MovieListDataSource {
    suspend fun getMovieList(
        genreId: String,
        page: Int
    ): MovieListResp
}