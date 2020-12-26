package com.fachreinrachim.mymovies.modules.movies.list;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.constants.ApiConstants
import com.fachreinrachim.mymovies.data.models.Movies
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.List;

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
class MovieAdapter(var items: ArrayList<Movies>?) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(v)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items!![position]

        holder.title.text = item.originalTitle
        holder.popularity.text = item.popularity.toString()
        holder.releasedDate.text = item.releaseDate
        holder.voted.text = item.voteAverage.toString()

        Glide.with(holder.poster.context)
            .load(ApiConstants.BASE_URL + item.posterPath)
            .error(
                ContextCompat.getDrawable(
                    holder.poster.context,
                    R.drawable.ic_on_demand_video
                )
            )
            .into(holder.poster)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title
        val poster = itemView.imageMovie
        val popularity = itemView.popularity
        val voted = itemView.voted
        val releasedDate = itemView.releasedDate
    }

    interface OnItemClickListener {
        fun onItemClick(item: Movies)
    }
}

