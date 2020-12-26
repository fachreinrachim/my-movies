package com.fachreinrachim.mymovies.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
data class ProductionCompanies (
    @SerializedName("id") val id : Int,
    @SerializedName("logo_path") val logoPath : String,
    @SerializedName("name") val name : String,
    @SerializedName("origin_country") val originCountry : String
)