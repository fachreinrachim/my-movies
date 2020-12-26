package com.fachreinrachim.mymovies.repositories.movie.datasource

import com.fachreinrachim.mymovies.data.models.Movies

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
interface MovieDataSource {
    suspend fun getMovie(movieId: String) : Movies
}