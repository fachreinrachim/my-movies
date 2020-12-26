package com.fachreinrachim.mymovies.modules.explore

import com.fachreinrachim.mymovies.data.models.Genres
import com.fachreinrachim.mymovies.modules.movies.list.MovieListActivity

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class ExploreRouter(private val activity: ExploreActivity) : ExploreContract.Router {
    override fun onFinish() {
        activity.finish()
    }

    override fun navigateToMovieList(genre: Genres) {
        MovieListActivity.start(
            activity,
            genre
        )
    }
}