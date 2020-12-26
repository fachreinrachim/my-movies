package com.fachreinrachim.mymovies.repositories.genre.datasource

import com.fachreinrachim.mymovies.api.Api
import com.fachreinrachim.mymovies.data.response.MovieGenresResp

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
class GenreRemoteDataSource : GenreDataSource {
    override suspend fun getMovieGenres(): MovieGenresResp =
        Api.service.getMovieGenres()
}