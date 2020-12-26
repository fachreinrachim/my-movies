package com.fachreinrachim.mymovies.base.di

import com.fachreinrachim.mymovies.base.BaseApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(target: BaseApplication)

    fun app(): BaseApplication

//    fun retrofit(): Retrofit

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(app: BaseApplication): Builder

        fun plus(module: AppModule): Builder

        fun build(): AppComponent
    }
}