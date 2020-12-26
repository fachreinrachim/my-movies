package com.fachreinrachim.mymovies.data.response

import com.fachreinrachim.mymovies.data.models.Videos
import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
data class MovieVideosResp(
    @SerializedName("id") val id : Int,
    @SerializedName("results") val results : List<Videos>
)