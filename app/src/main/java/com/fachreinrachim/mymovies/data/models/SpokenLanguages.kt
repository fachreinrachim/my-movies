package com.fachreinrachim.mymovies.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
data class SpokenLanguages(
    @SerializedName("english_name") val englishName : String,
    @SerializedName("iso_639_1") val iso6391 : String,
    @SerializedName("name") val name : String
)