package com.fachreinrachim.mymovies.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 27/12/20.
 */
data class AuthorDetails(
    @SerializedName("name") val name : String,
    @SerializedName("username") val username : String,
    @SerializedName("avatar_path") val avatarPath : String,
    @SerializedName("rating") val rating : Int
) : Serializable