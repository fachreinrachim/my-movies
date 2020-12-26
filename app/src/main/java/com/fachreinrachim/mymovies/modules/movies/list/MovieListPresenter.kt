package com.fachreinrachim.mymovies.modules.movies.list

import com.fachreinrachim.mymovies.base.presenter.BasePresenter
import com.fachreinrachim.mymovies.data.models.Genres
import com.fachreinrachim.mymovies.repositories.movielist.MovieListRepositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class MovieListPresenter(
    private val router: MovieListContract.Router
) :
    MovieListContract.Presenter, BasePresenter() {

    lateinit var genre: Genres

    var currentPage: Int = 1

    var isLastPage = false
    var isLoading = false
    var itemCount = 0
    var totalDataCount = 0

    @JvmField
    @Inject
    var view: MovieListContract.View? = null

    override fun getMoviesByGenre() {
        launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    MovieListRepositories.INSTANCE.getMovieListByGenre(
                        genre.id.toString(), currentPage
                    )
                }

                totalDataCount = response?.totalResults ?: 0
                isLoading = false

                if (!response?.results.isNullOrEmpty()) {
                    view?.showMovies(response?.results)
                } else {
                    view?.showEmptyData()
                }

            } catch (e: Exception) {
                e.printStackTrace()
                view?.showMessage(e.message)
                isLoading = false
            }
        }
    }

    override fun navigateToMovieDetail(id: Int) {
        router.navigateToMovieDetail(id)
    }

    public override fun onViewDestroyed() {
        cancel()
    }

}