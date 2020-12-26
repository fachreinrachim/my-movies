package com.fachreinrachim.mymovies.modules.movies.list.di

import com.fachreinrachim.mymovies.base.di.ActivityScope
import com.fachreinrachim.mymovies.base.di.AppComponent
import com.fachreinrachim.mymovies.modules.movies.list.MovieListActivity
import dagger.BindsInstance
import dagger.Component

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

@ActivityScope
@Component(modules = [MovieListModule::class], dependencies = [AppComponent::class])
interface MovieListComponent {

    fun inject(target: MovieListActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MovieListActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: MovieListModule): Builder

        fun build(): MovieListComponent
    }
}