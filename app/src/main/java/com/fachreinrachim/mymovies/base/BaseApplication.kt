package com.fachreinrachim.mymovies.base

import android.app.Application
import com.fachreinrachim.mymovies.base.di.AppComponent
import com.fachreinrachim.mymovies.base.di.AppModule
import com.fachreinrachim.mymovies.base.di.DaggerAppComponent
import com.fachreinrachim.mymovies.repositories.genre.GenreRepositories
import com.fachreinrachim.mymovies.repositories.genre.datasource.GenreRemoteDataSource
import com.fachreinrachim.mymovies.repositories.movie.MovieRepositories
import com.fachreinrachim.mymovies.repositories.movie.datasource.MovieRemoteDataSource
import com.fachreinrachim.mymovies.repositories.movielist.MovieListRepositories
import com.fachreinrachim.mymovies.repositories.movielist.datasource.MovieListRemoteDataSource
import com.fachreinrachim.mymovies.repositories.reviews.ReviewsRepositories
import com.fachreinrachim.mymovies.repositories.reviews.datasource.ReviewsRemoteDataSource
import com.fachreinrachim.mymovies.repositories.videos.VideosRepositories
import com.fachreinrachim.mymovies.repositories.videos.datasources.VideosRemoteDataSource

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
class BaseApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)

        GenreRepositories.INSTANCE.apply {
            init(GenreRemoteDataSource())
        }

        MovieListRepositories.INSTANCE.apply {
            init(MovieListRemoteDataSource())
        }

        MovieRepositories.INSTANCE.apply {
            init(MovieRemoteDataSource())
        }

        VideosRepositories.INSTANCE.apply {
            init(VideosRemoteDataSource())
        }

        ReviewsRepositories.INSTANCE.apply {
            init(ReviewsRemoteDataSource())
        }

    }
}