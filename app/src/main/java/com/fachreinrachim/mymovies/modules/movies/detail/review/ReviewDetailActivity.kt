package com.fachreinrachim.mymovies.modules.movies.detail.review

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fachreinrachim.mymovies.R
import com.fachreinrachim.mymovies.base.activity.BaseActivity
import com.fachreinrachim.mymovies.data.models.Reviews
import com.fachreinrachim.mymovies.modules.movies.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_review_detail.*
import kotlinx.android.synthetic.main.toolbar_back.*
import kotlinx.android.synthetic.main.toolbar_common.view.*

class ReviewDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_detail)

        getDataFromIntent()
        initView()
    }

    private fun initView() {
        toolbar.titleToolbar.text = getString(R.string.review)
        back.setOnClickListener {
            finish()
        }
    }

    private fun getDataFromIntent() {
        val review = intent.getSerializableExtra(REVIEW_INTENT) as Reviews

        if (review != null) {
            initReview(review)
        }
    }

    private fun initReview(data: Reviews) {

        author.text = data.author
        created.text = data.createdAt
        rating.text = data.authorDetails.rating.toString()
        review.text = data.content
    }

    companion object {
        const val REVIEW_INTENT = "review-intent"

        fun start(context: Context, review: Reviews) {
            val intent = Intent(context, ReviewDetailActivity::class.java)
            intent.putExtra(REVIEW_INTENT, review)

            context?.startActivity(intent)
        }
    }
}