package com.fachreinrachim.mymovies.repositories.videos

import com.fachreinrachim.mymovies.data.response.MovieVideosResp
import com.fachreinrachim.mymovies.repositories.videos.datasources.VideoDataSource
import com.fachreinrachim.mymovies.repositories.videos.datasources.VideosRemoteDataSource

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
class VideosRepositories {
    private var dataSource: VideoDataSource? = null

    companion object {
        val INSTANCE by lazy { VideosRepositories() }
    }

    fun init (dataSource: VideosRemoteDataSource) {
        this.dataSource = dataSource
    }

    suspend fun getVideosByMovie(
        movieId: String
    ): MovieVideosResp? {
        return dataSource?.getVideosByMovie(
            movieId
        )
    }
}