package com.fachreinrachim.mymovies.repositories.videos.datasources

import com.fachreinrachim.mymovies.api.Api
import com.fachreinrachim.mymovies.data.response.MovieListResp
import com.fachreinrachim.mymovies.data.response.MovieVideosResp

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
class VideosRemoteDataSource : VideoDataSource {
    override suspend fun getVideosByMovie(movieId: String): MovieVideosResp {
        return Api.service.getMovieVideos(movieId)
    }

}