package com.fachreinrachim.mymovies.base.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * @author M.Fachrein Rachim <fachrein@99.co>
 * @since 25/12/20.
 */
abstract class BasePresenter : CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    protected abstract fun onViewDestroyed()
}