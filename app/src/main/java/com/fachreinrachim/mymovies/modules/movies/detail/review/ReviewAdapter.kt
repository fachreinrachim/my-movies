package com.fachreinrachim.mymovies.modules.movies.detail.review;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.data.models.Reviews
import kotlinx.android.synthetic.main.item_review.view.*
import java.util.List;

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 27/12/20.
 */
class ReviewAdapter(private var items: ArrayList<Reviews>?) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(v)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = items!![position]

        holder.author.text = item.author
        holder.created.text = item.createdAt
        holder.rating.text = item.authorDetails.rating.toString()
        holder.review.text = item.content

        holder.itemView.setOnClickListener {
            listener?.onItemClick(item)
        }

        holder.seeMore.setOnClickListener {
            listener?.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun updateItems(result: java.util.ArrayList<Reviews>) {
        this.items = result
        notifyDataSetChanged()
    }

    inner class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val author = itemView.author
        val rating = itemView.rating
        val created = itemView.created
        val review = itemView.review
        val seeMore = itemView.seeMore
    }

    interface OnItemClickListener {
        fun onItemClick(item: Reviews)
    }
}

