package com.fachreinrachim.mymovies.modules.movies.detail.di

import com.fachreinrachim.mymovies.base.di.ActivityScope
import com.fachreinrachim.mymovies.modules.movies.detail.MovieDetailActivity
import com.fachreinrachim.mymovies.modules.movies.detail.MovieDetailContract
import com.fachreinrachim.mymovies.modules.movies.detail.MovieDetailPresenter
import com.fachreinrachim.mymovies.modules.movies.detail.MovieDetailRouter
import dagger.Module
import dagger.Provides

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

@Module
class MovieDetailModule {
    @Provides
    @ActivityScope
    fun presenter(router: MovieDetailContract.Router) =
        MovieDetailPresenter(
            router
        )

    @Provides
    @ActivityScope
    fun router(activity: MovieDetailActivity): MovieDetailContract.Router =
        MovieDetailRouter(
            activity
        )
}