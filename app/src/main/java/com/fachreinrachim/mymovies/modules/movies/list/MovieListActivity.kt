package com.fachreinrachim.mymovies.modules.movies.list;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.base.BaseApplication
import com.fachreinrachim.mymovies.base.activity.BaseActivity
import com.fachreinrachim.mymovies.data.models.Genres
import com.fachreinrachim.mymovies.data.models.Movies
import com.fachreinrachim.mymovies.modules.movies.list.di.DaggerMovieListComponent
import com.fachreinrachim.mymovies.modules.movies.list.di.MovieListComponent
import com.fachreinrachim.mymovies.modules.movies.list.di.MovieListModule
import com.fachreinrachim.mymovies.utils.RecyclerViewItemDecoration
import com.fachreinrachim.mymovies.utils.dp
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.toolbar_back.*
import kotlinx.android.synthetic.main.toolbar_back.view.*
import javax.inject.Inject

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class MovieListActivity : BaseActivity(), MovieListContract.View, MovieAdapter.OnItemClickListener {

    private lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var presenter: MovieListPresenter

    val component: MovieListComponent by lazy {
        DaggerMovieListComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activity(this)
            .plus(MovieListModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list) //place your xml here
        initView()

        component.inject(this)
        presenter.view = this

        getDataFromIntent()
    }

    private fun getDataFromIntent() {
        presenter.genre = intent.getSerializableExtra(GENRE_INTENT) as Genres

        if (presenter.genre == null) return

        toolbar.titleToolbar.text = presenter.genre.name
        back.setOnClickListener {
            finish()
        }

        presenter.getMoviesByGenre()
    }

    private fun initView() {
        val adapter = MovieAdapter(ArrayList())
        adapter.listener = this

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        recyclerMovies.layoutManager = layoutManager
        recyclerMovies.addItemDecoration(RecyclerViewItemDecoration(8.dp))
        recyclerMovies.adapter = adapter

        nestedScroll.setOnScrollChangeListener {
                v: NestedScrollView, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->

            if (v.getChildAt(v.childCount - 1) != null) {
                if (scrollY >= v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight
                    && scrollY > oldScrollY
                ) {
                    //code to fetch more data for endless scrolling
                    loadMoreMovies()
                }
            }
        }
    }

    private fun loadMoreMovies() {
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (!presenter.isLoading && !presenter.isLastPage) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                && firstVisibleItemPosition >= 0
                && totalItemCount >= 20)
            {

                if ((recyclerMovies.adapter as MovieAdapter).items?.size!! < presenter.totalDataCount) {
                    presenter.isLoading = true
                    presenter.currentPage++

                    presenter.getMoviesByGenre()
                }
            }
        }
    }

    companion object {
        const val GENRE_INTENT = "genre-id"

        fun start(context: Context, genre: Genres) {
            val intent = Intent(context, MovieListActivity::class.java)
            intent.putExtra(GENRE_INTENT, genre)

            context?.startActivity(intent)
        }
    }

    override fun showMovies(results: List<Movies>?) {
        if (results == null) {
            return
        }

        runOnUiThread {
            (recyclerMovies.adapter as MovieAdapter).items?.addAll(results)
            (recyclerMovies.adapter as MovieAdapter).notifyDataSetChanged()
        }
    }

    override fun showMessage(message: String?) {
        message?.let { showToastMessage(it) }
    }

    override fun showEmptyData() {
        showToastMessage(
            getString(R.string.empty_data)
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onViewDestroyed()
    }

    override fun onItemClick(item: Movies) {
        presenter.navigateToMovieDetail(item.id)
    }

}