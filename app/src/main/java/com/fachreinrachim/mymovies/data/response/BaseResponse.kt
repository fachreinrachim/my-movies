package com.fachreinrachim.mymovies.data.response

import com.fachreinrachim.mymovies.data.models.Reviews
import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
abstract class BaseListResponse<T> {
    @SerializedName("page") val page : Int? = null
    @SerializedName("results") val results : List<T> ? = null
    @SerializedName("total_pages") val totalPages : Int ? = null
    @SerializedName("total_results") val totalResults : Int ? = null
}