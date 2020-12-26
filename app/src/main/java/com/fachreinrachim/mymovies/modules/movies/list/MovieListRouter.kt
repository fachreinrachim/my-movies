package com.fachreinrachim.mymovies.modules.movies.list

import com.fachreinrachim.mymovies.modules.movies.detail.MovieDetailActivity

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class MovieListRouter(
    private val activity: MovieListActivity
) : MovieListContract.Router {
    override fun onFinish() {
        activity.finish()
    }

    override fun navigateToMovieDetail(id: Int) {
        MovieDetailActivity.start(
            activity, id.toString()
        )
    }
}