package com.fachreinrachim.mymovies.modules.movies.list.di

import com.fachreinrachim.mymovies.base.di.ActivityScope
import com.fachreinrachim.mymovies.modules.movies.list.MovieListActivity
import com.fachreinrachim.mymovies.modules.movies.list.MovieListContract
import com.fachreinrachim.mymovies.modules.movies.list.MovieListPresenter
import com.fachreinrachim.mymovies.modules.movies.list.MovieListRouter
import dagger.Module
import dagger.Provides

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

@Module
class MovieListModule {
    @Provides
    @ActivityScope
    fun presenter(router: MovieListContract.Router) =
        MovieListPresenter(router)

    @Provides
    @ActivityScope
    fun router(activity: MovieListActivity): MovieListContract.Router =
        MovieListRouter(activity)
}