package com.fachreinrachim.mymovies.modules.movies.detail

import com.fachreinrachim.mymovies.data.models.Movies
import com.fachreinrachim.mymovies.data.models.Reviews
import com.fachreinrachim.mymovies.data.models.Videos

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

interface MovieDetailContract {

    interface View {
        fun showMovie(response: Movies)
        fun showEmptyData()
        fun showMessage(message: String?)
        fun showVideos(response: List<Videos>)
        fun showReviews(results: List<Reviews>?)

    }

    interface Presenter {
        fun getMovieDetail(movieId: String)
        fun getMoviesVideos(movieId: String)
        fun getMoviesReviews(movieId: String)
        fun navigateToReviewDetail(item: Reviews)
    }

    interface Router {
        fun onFinish()
        fun navigateToReviewDetail(item: Reviews)
    }
}