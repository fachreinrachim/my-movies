package com.fachreinrachim.mymovies.modules.explore.genres

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.data.models.Genres

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
class GenreAdapter(
    val context: Context,
    var items: ArrayList<Genres>
) : BaseAdapter() {

    var listener : OnItemClickListener? = null

    override fun getView(
        position: Int,
        convertView: View?,
        viewGroup: ViewGroup?
    ): View? {
        val item = items[position]
        var view: View? = null

        if (view == null) {
            var layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.item_genre, null)
        }

        val genre = view?.findViewById<TextView>(R.id.title)

        genre?.text = item.name

        view?.setOnClickListener {
            listener?.onItemClick(item)
        }

        return view
    }

    override fun getItem(position: Int): Genres {
        return items[position]
    }

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = items?.size ?: 0

    interface OnItemClickListener {
        fun onItemClick(genre: Genres)
    }
}