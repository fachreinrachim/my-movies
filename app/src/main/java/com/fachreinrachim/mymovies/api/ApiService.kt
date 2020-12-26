package com.fachreinrachim.mymovies.api

import com.fachreinrachim.mymovies.constants.ApiConstants
import com.fachreinrachim.mymovies.data.models.Movies
import com.fachreinrachim.mymovies.data.response.MovieGenresResp
import com.fachreinrachim.mymovies.data.response.MovieListResp
import com.fachreinrachim.mymovies.data.response.MovieVideosResp
import com.fachreinrachim.mymovies.data.response.ReviewListResp
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
interface ApiService {

    @GET("genre/movie/list?api_key=" + ApiConstants.API_KEY)
    suspend fun getMovieGenres(): MovieGenresResp

    @GET("discover/movie?api_key=" + ApiConstants.API_KEY)
    suspend fun getMoviesByGenre(
        @Query("with_genres") genre: String?,
        @Query("page") page: Int?
    ): MovieListResp

    @GET("movie/{movie_id}?api_key=" + ApiConstants.API_KEY)
    suspend fun getMovieById(
        @Path("movie_id") id: String?
    ): Movies

    @GET("movie/{movie_id}/videos?api_key=" + ApiConstants.API_KEY)
    suspend fun getMovieVideos(
        @Path("movie_id") id: String?
    ): MovieVideosResp

    @GET("movie/{movie_id}/reviews?api_key=" + ApiConstants.API_KEY)
    suspend fun getMovieReviews(
        @Path("movie_id") id: String?
    ): ReviewListResp
}