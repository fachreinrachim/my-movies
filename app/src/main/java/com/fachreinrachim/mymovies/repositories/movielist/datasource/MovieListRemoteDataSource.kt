package com.fachreinrachim.mymovies.repositories.movielist.datasource

import com.fachreinrachim.mymovies.api.Api
import com.fachreinrachim.mymovies.data.response.MovieListResp

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
class MovieListRemoteDataSource : MovieListDataSource {
    override suspend fun getMovieList(genreId: String, page: Int): MovieListResp {
       return Api.service.getMoviesByGenre(genreId, page)
    }
}