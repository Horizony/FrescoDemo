package com.cn.horizon.life.app.base

import android.support.v7.app.AppCompatActivity
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by horizony on 2017/8/29.
 */
open class BaseActivity : AppCompatActivity() {
    val compositeSub: CompositeSubscription = CompositeSubscription()

    open fun <T> addSubscription(observable: Observable<T>, subscriber: Subscriber<T>) {
        compositeSub.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber))

    }

    override fun onDestroy() {
        super.onDestroy()
        if (compositeSub.hasSubscriptions()) {
            compositeSub.unsubscribe()
        }
    }

    fun AppCompatActivity.showToast(){

    }
}



