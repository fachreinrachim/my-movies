package com.fachreinrachim.mymovies.repositories.movie.datasource

import com.fachreinrachim.mymovies.api.Api
import com.fachreinrachim.mymovies.data.models.Movies

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
class MovieRemoteDataSource : MovieDataSource {
    override suspend fun getMovie(movieId: String): Movies {
        return Api.service.getMovieById(movieId)
    }
}