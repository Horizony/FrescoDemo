package com.cn.horizon.life.app

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by horizony on 2017/8/28.
 */
class LifeApplication : Application() {

    companion object {
        var appContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        Fresco.initialize(this)
    }
}