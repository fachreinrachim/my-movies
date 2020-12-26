package com.fachreinrachim.mymovies.modules.explore.di

import com.fachreinrachim.mymovies.base.di.ActivityScope
import com.fachreinrachim.mymovies.base.di.AppComponent
import com.fachreinrachim.mymovies.modules.explore.ExploreActivity
import dagger.BindsInstance
import dagger.Component

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

@ActivityScope
@Component(modules = [ExploreModule::class], dependencies = [AppComponent::class])
interface ExploreComponent {

    fun inject(target: ExploreActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: ExploreActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: ExploreModule): Builder

        fun build(): ExploreComponent
    }
}