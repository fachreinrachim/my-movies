package com.fachreinrachim.mymovies.modules.movies.detail;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.base.BaseApplication
import com.fachreinrachim.mymovies.base.activity.BaseActivity
import com.fachreinrachim.mymovies.data.models.Movies
import com.fachreinrachim.mymovies.data.models.Reviews
import com.fachreinrachim.mymovies.data.models.Videos
import com.fachreinrachim.mymovies.modules.movies.detail.di.DaggerMovieDetailComponent
import com.fachreinrachim.mymovies.modules.movies.detail.di.MovieDetailComponent
import com.fachreinrachim.mymovies.modules.movies.detail.di.MovieDetailModule
import com.fachreinrachim.mymovies.modules.movies.detail.overview.MovieGenreAdapter
import com.fachreinrachim.mymovies.modules.movies.detail.review.ReviewAdapter
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_list.toolbar
import kotlinx.android.synthetic.main.toolbar_back.*
import kotlinx.android.synthetic.main.toolbar_common.view.*
import javax.inject.Inject


/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 *
 */

class MovieDetailActivity : BaseActivity(), MovieDetailContract.View,
    ReviewAdapter.OnItemClickListener {

    @Inject
    lateinit var presenter: MovieDetailPresenter

    val component: MovieDetailComponent by lazy {
        DaggerMovieDetailComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activity(this)
            .plus(MovieDetailModule())
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail) //place your xml here

        component.inject(this)
        presenter.view = this

        getDataFromIntent()
        initView()
    }

    private fun getDataFromIntent() {
        val movieId = intent.getStringExtra(MOVIE_INTENT) ?: return

        presenter.getMovieDetail(movieId)
        presenter.getMoviesVideos(movieId)
        presenter.getMoviesReviews(movieId)
    }

    private fun initView() {
        back.setOnClickListener {
            finish()
        }

        toolbar.titleToolbar.text = getString(R.string.movies_detail)

        lifecycle.addObserver(youtubePlayerView)

        val layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        recyclerGenres.layoutManager = layoutManager
        recyclerGenres.adapter = MovieGenreAdapter(ArrayList())

        val layoutManagerReviews = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val reviewAdapter = ReviewAdapter(ArrayList())
        reviewAdapter.listener = this

        recyclerReviews.layoutManager = layoutManagerReviews
        recyclerReviews.adapter = reviewAdapter
    }

    override fun showMessage(message: String?) {
        message?.let { showToastMessage(it) }
    }

    override fun showVideos(response: List<Videos>) {
        runOnUiThread {
            youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(response[0].key, 0f)
                }
            })
        }
    }

    override fun showReviews(results: List<Reviews>?) {
        runOnUiThread {
            (recyclerReviews.adapter as ReviewAdapter).updateItems(results as ArrayList)
        }
    }

    override fun showMovie(response: Movies) {
        runOnUiThread {
            movieTitle.text = response.title
            popularity.text = response.popularity.toString()
//            releasedDate.text = item.releaseDate
            voted.text = response.voteAverage.toString()
            overview.text = response.overview

            (recyclerGenres.adapter as MovieGenreAdapter).updateItems(response.genres)
        }
    }

    override fun showEmptyData() {
        runOnUiThread {
            reviewsContainer.visibility = View.GONE
        }
    }


    companion object {
        const val MOVIE_INTENT = "movie-id"

        fun start(context: Context, movieId: String) {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE_INTENT, movieId)

            context?.startActivity(intent)
        }
    }

    override fun onItemClick(item: Reviews) {
        presenter.navigateToReviewDetail(item)
    }
}