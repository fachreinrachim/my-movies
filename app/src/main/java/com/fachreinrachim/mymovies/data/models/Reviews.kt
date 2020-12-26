package com.fachreinrachim.mymovies.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 27/12/20.
 */
data class Reviews(
    @SerializedName("author") val author : String,
    @SerializedName("author_details") val authorDetails : AuthorDetails,
    @SerializedName("content") val content : String,
    @SerializedName("created_at") val createdAt : String,
    @SerializedName("id") val id : String,
    @SerializedName("updated_at") val updatedAt : String,
    @SerializedName("url") val url : String
) : Serializable