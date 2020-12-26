package com.fachreinrachim.mymovies.modules.movies.detail.di

import com.fachreinrachim.mymovies.base.di.ActivityScope
import com.fachreinrachim.mymovies.base.di.AppComponent
import com.fachreinrachim.mymovies.modules.movies.detail.MovieDetailActivity
import dagger.BindsInstance
import dagger.Component

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

@ActivityScope
@Component(modules = [MovieDetailModule::class], dependencies = [AppComponent::class])
interface MovieDetailComponent {

    fun inject(target: MovieDetailActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MovieDetailActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: MovieDetailModule): Builder

        fun build(): MovieDetailComponent
    }
}