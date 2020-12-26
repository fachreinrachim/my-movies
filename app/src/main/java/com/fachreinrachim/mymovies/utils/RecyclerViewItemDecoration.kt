package com.fachreinrachim.mymovies.utils

import android.content.res.Resources
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 02/10/20.
 */
class RecyclerViewItemDecoration(
    /*
    * This is for adding decoration for recycler view items
    * such as paddings and margins between them
    *
    * */
    private val offset: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when {
            parent.getChildAdapterPosition(view) == 0 -> {
                outRect.top = offset * 2
                outRect.bottom = offset
            }
            parent.getChildAdapterPosition(view) == (parent.adapter?.itemCount?.minus(1)) -> {
                outRect.bottom = offset * 2
                outRect.top = offset
            }
            else -> {
                outRect.top = offset
                outRect.bottom = offset
            }
        }
        outRect.left = offset
        outRect.right = offset * 2
    }
}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()