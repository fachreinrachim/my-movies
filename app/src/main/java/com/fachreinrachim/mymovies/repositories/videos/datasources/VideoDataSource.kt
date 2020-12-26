package com.fachreinrachim.mymovies.repositories.videos.datasources

import com.fachreinrachim.mymovies.data.response.MovieVideosResp

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
interface VideoDataSource {
    suspend fun getVideosByMovie(movieId: String) : MovieVideosResp
}