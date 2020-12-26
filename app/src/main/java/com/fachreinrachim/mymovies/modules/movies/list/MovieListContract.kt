package com.fachreinrachim.mymovies.modules.movies.list

import com.fachreinrachim.mymovies.data.models.Genres
import com.fachreinrachim.mymovies.data.models.Movies

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

interface MovieListContract {

    interface View {
        fun showMovies(results: List<Movies>?)
        fun showMessage(message: String?)
        fun showEmptyData()
    }

    interface Presenter {
        fun getMoviesByGenre()
        fun navigateToMovieDetail(id: Int)

    }

    interface Router {
        fun onFinish()
        fun navigateToMovieDetail(id: Int)
    }
}