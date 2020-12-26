package com.fachreinrachim.mymovies.modules.explore

import com.fachreinrachim.mymovies.base.presenter.BasePresenter
import com.fachreinrachim.mymovies.data.models.Genres
import com.fachreinrachim.mymovies.repositories.genre.GenreRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class ExplorePresenter(
    private val router: ExploreContract.Router
) : ExploreContract.Presenter, BasePresenter() {

    @JvmField
    @Inject
    var view: ExploreContract.View? = null

    override fun getMovieGenres() {
        launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    GenreRepositories.INSTANCE.getMovieGenres()
                }

                if (!response?.data.isNullOrEmpty()) {
                    view?.showGenres(response?.data)
                } else {
                    view?.showEmptyData()
                }

            } catch (e: Exception) {
                e.printStackTrace()
                view?.showMessage(e.message)
            }
        }
    }

    override fun navigateToMovieList(genre: Genres) {
        router.navigateToMovieList(genre)
    }

    override fun onViewDestroyed() {
        cancel()
    }

}