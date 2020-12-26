package com.fachreinrachim.mymovies.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
data class BelongsToCollection(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null

)