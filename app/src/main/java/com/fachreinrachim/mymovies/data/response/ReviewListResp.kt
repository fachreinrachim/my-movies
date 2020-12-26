package com.fachreinrachim.mymovies.data.response

import com.fachreinrachim.mymovies.data.models.Reviews
import com.google.gson.annotations.SerializedName

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 27/12/20.
 */
class ReviewListResp: BaseListResponse<Reviews>() {
    @SerializedName("id") val id : Int? = null
}