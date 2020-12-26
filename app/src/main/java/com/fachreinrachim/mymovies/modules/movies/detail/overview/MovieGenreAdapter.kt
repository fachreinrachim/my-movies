package com.fachreinrachim.mymovies.modules.movies.detail.overview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.data.models.Genres
import kotlinx.android.synthetic.main.item_movie_genre.view.*
import java.util.List;

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 26/12/20.
 */
class MovieGenreAdapter(private var items: ArrayList<Genres>?) :
    RecyclerView.Adapter<MovieGenreAdapter.GenreViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_genre, parent, false)
        return GenreViewHolder(v)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val item = items!![position]

        holder.name.text = item.name
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun updateItems(genres: kotlin.collections.List<Genres>) {
        this.items = genres as ArrayList<Genres>
        notifyDataSetChanged()
    }

    inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.genre
    }

    interface OnItemClickListener {
        fun onItemClick(item: Genres)
    }
}

