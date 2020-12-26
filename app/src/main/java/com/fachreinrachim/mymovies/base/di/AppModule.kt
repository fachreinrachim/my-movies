package com.fachreinrachim.mymovies.base.di

import android.content.Context
import com.fachreinrachim.mymovies.base.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
@Module
class AppModule(private val application: BaseApplication) {
    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application
    }
}