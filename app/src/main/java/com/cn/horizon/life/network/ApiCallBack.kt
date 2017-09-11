package com.cn.horizon.life.network

import android.support.annotation.NonNull
import retrofit2.HttpException
import rx.Subscriber

/**
 * Created by horizony on 2017/8/29.
 */
abstract class ApiCallBack<T> : Subscriber<T>() {
    abstract fun onSuccess(t: T)
    abstract fun onFailure(message: String?)
    abstract fun onFinish()

    override fun onCompleted() {
        onFinish()
    }
    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(@NonNull e: Throwable) {
        if (e is HttpException) {
            val code = e.code()
            var msg: String = ""
            if (code == 504) {
                msg = "网络不给力"
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后重试"
            }
            onFailure(message = msg)
        } else {
            onFailure(message = e.toString())
        }
        onFinish()
    }
}
