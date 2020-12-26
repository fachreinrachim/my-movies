package com.fachreinrachim.mymovies.modules.movies.detail

import com.fachreinrachim.mymovies.base.presenter.BasePresenter
import com.fachreinrachim.mymovies.data.models.Reviews
import com.fachreinrachim.mymovies.repositories.movie.MovieRepositories
import com.fachreinrachim.mymovies.repositories.reviews.ReviewsRepositories
import com.fachreinrachim.mymovies.repositories.videos.VideosRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class MovieDetailPresenter(private val router: MovieDetailContract.Router) :
    MovieDetailContract.Presenter, BasePresenter() {

    @JvmField
    @Inject
    var view: MovieDetailContract.View? = null

    override fun getMovieDetail(movieId: String) {
        launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    MovieRepositories.INSTANCE.getMovieById(
                        movieId
                    )
                }

                if (response != null) {
                    view?.showMovie(response)
                } else {
                    view?.showEmptyData()
                }

            } catch (e: Exception) {
                e.printStackTrace()
                view?.showMessage(e.message)
            }
        }
    }

    override fun getMoviesVideos(movieId: String) {
        launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    VideosRepositories.INSTANCE.getVideosByMovie(
                        movieId
                    )
                }

                if (response != null && response.results.isNotEmpty()) {
                    view?.showVideos(response.results)
                } else {
                    view?.showEmptyData()
                }

            } catch (e: Exception) {
                e.printStackTrace()
                view?.showMessage(e.message)
            }
        }
    }

    override fun getMoviesReviews(movieId: String) {
        launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    ReviewsRepositories.INSTANCE.getReviewsByMovie(
                        movieId
                    )
                }

                if (response != null) {
                    if (response.results?.size == 0) {
                        view?.showEmptyData()
                    } else {
                        view?.showReviews(response.results)
                    }
                } else {
                    view?.showEmptyData()
                }

            } catch (e: Exception) {
                e.printStackTrace()
                view?.showMessage(e.message)
            }
        }
    }

    override fun navigateToReviewDetail(item: Reviews) {
        router.navigateToReviewDetail(item)
    }

    override fun onViewDestroyed() {
        cancel()
    }

}