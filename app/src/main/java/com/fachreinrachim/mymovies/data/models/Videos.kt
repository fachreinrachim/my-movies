package com.fachreinrachim.mymovies.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
data class Videos(
    @SerializedName("id") val id : String,
    @SerializedName("iso_639_1") val iso_639_1 : String,
    @SerializedName("iso_3166_1") val iso_3166_1 : String,
    @SerializedName("key") val key : String,
    @SerializedName("name") val name : String,
    @SerializedName("site") val site : String,
    @SerializedName("size") val size : Int,
    @SerializedName("type") val type : String

)