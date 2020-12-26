package com.fachreinrachim.mymovies.data.response

import com.fachreinrachim.mymovies.data.models.Genres
import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */

data class MovieGenresResp (
    @SerializedName("genres")
    val data : ArrayList<Genres>? = null
)