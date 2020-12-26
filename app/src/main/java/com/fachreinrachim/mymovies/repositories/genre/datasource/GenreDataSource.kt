package com.fachreinrachim.mymovies.repositories.genre.datasource

import com.fachreinrachim.mymovies.data.response.MovieGenresResp

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
interface GenreDataSource {
    suspend fun getMovieGenres() : MovieGenresResp
}