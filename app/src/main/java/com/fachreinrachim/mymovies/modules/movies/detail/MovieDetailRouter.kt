package com.fachreinrachim.mymovies.modules.movies.detail

import com.fachreinrachim.mymovies.data.models.Reviews
import com.fachreinrachim.mymovies.modules.movies.detail.review.ReviewDetailActivity

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class MovieDetailRouter(private val activity: MovieDetailActivity) : MovieDetailContract.Router {
    override fun onFinish() {
        activity.finish()
    }

    override fun navigateToReviewDetail(item: Reviews) {
        ReviewDetailActivity.start(
            activity,
            item
        )
    }
}