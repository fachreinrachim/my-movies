package com.fachreinrachim.mymovies.repositories.reviews.datasource

import com.fachreinrachim.mymovies.data.response.ReviewListResp

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 27/12/20.
 */
interface ReviewsDataSource {
    suspend fun getMovieReviews(movieId: String) : ReviewListResp
}