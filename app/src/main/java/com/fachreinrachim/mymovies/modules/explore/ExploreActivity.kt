package com.fachreinrachim.mymovies.modules.explore;

import android.os.Bundle
import com.fachreinrachim.mymovies.base.BaseApplication
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.base.activity.BaseActivity
import com.fachreinrachim.mymovies.data.models.Genres
import com.fachreinrachim.mymovies.modules.explore.di.DaggerExploreComponent
import com.fachreinrachim.mymovies.modules.explore.di.ExploreComponent
import com.fachreinrachim.mymovies.modules.explore.di.ExploreModule
import com.fachreinrachim.mymovies.modules.explore.genres.GenreAdapter
import kotlinx.android.synthetic.main.activity_explore.*
import javax.inject.Inject

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class ExploreActivity : BaseActivity(),
    ExploreContract.View, GenreAdapter.OnItemClickListener {
    @Inject
    lateinit var presenter: ExplorePresenter

    val component: ExploreComponent by lazy {
        DaggerExploreComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activity(this)
            .plus(ExploreModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore) //place your xml here

        component.inject(this)

        presenter.view = this
        presenter.getMovieGenres()

        initView()
    }

    private fun initView() {
        val adapter = GenreAdapter(
            this,
            ArrayList()
        )

        adapter.listener = this
        gridGenres.adapter = adapter
    }

    override fun showMessage(message: String?) {
        message?.let { showToastMessage(it) }
    }

    override fun showGenres(data: ArrayList<Genres>?) {
        if (data == null) {
            return
        }

        runOnUiThread {
            (gridGenres.adapter as GenreAdapter).items = data
            (gridGenres.adapter as GenreAdapter).notifyDataSetChanged()
        }
    }

    override fun showEmptyData() {
        showToastMessage(
            getString(R.string.empty_data)
        )
    }

    override fun onItemClick(genre: Genres) {
        presenter.navigateToMovieList(genre)
    }

}