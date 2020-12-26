package com.fachreinrachim.mymovies.base.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
abstract class BaseActivity : AppCompatActivity() {

    fun showToastMessage(msg: String) {
        runOnUiThread {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }
}