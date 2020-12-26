package com.fachreinrachim.mymovies.modules.explore.di

import com.fachreinrachim.mymovies.base.di.ActivityScope
import com.fachreinrachim.mymovies.modules.explore.ExploreActivity
import com.fachreinrachim.mymovies.modules.explore.ExploreContract
import com.fachreinrachim.mymovies.modules.explore.ExplorePresenter
import com.fachreinrachim.mymovies.modules.explore.ExploreRouter
import dagger.Module
import dagger.Provides

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

@Module
class ExploreModule {
    @Provides
    @ActivityScope
    fun presenter(router: ExploreContract.Router) =
        ExplorePresenter(router)

    @Provides
    @ActivityScope
    fun router(activity: ExploreActivity): ExploreContract.Router =
        ExploreRouter(activity)
}