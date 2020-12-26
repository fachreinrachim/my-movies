package com.fachreinrachim.mymovies.repositories.reviews

import com.fachreinrachim.mymovies.data.response.ReviewListResp
import com.fachreinrachim.mymovies.repositories.reviews.datasource.ReviewsDataSource
import com.fachreinrachim.mymovies.repositories.reviews.datasource.ReviewsRemoteDataSource

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 27/12/20.
 */
class ReviewsRepositories {
    private var dataSource: ReviewsDataSource? = null

    companion object {
        val INSTANCE by lazy { ReviewsRepositories() }
    }

    fun init (dataSource: ReviewsRemoteDataSource) {
        this.dataSource = dataSource
    }

    suspend fun getReviewsByMovie(
        movieId: String
    ): ReviewListResp? {
        return dataSource?.getMovieReviews(
            movieId
        )
    }
}