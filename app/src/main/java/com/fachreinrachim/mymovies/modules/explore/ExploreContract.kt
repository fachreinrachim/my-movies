package com.fachreinrachim.mymovies.modules.explore

import com.fachreinrachim.mymovies.data.models.Genres

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

interface ExploreContract {

    interface View {
        fun showMessage(message: String?)
        fun showGenres(data: ArrayList<Genres>?)
        fun showEmptyData()
    }

    interface Presenter {
        fun getMovieGenres()
        fun navigateToMovieList(genre: Genres)
    }

    interface Router {
        fun onFinish()
        fun navigateToMovieList(genre: Genres)
    }
}