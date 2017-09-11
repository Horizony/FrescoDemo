package com.cn.horizon.life.widgets.fresco

import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable

/**
 * Created by horizony on 2017/8/31.
 */
abstract class ShapeDrawable constructor(width: Float, height: Float) : Drawable() {
    var paint: Paint? = null
    var width: Float = 0F
    var height: Float = 0F

    init {
        this.width = width
        this.height = height
        paint = Paint()
    }

    override fun setAlpha(alpha: Int) {
        paint?.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint?.colorFilter = colorFilter
    }

    override fun getIntrinsicWidth(): Int {
        return width.toInt()
    }

    override fun getIntrinsicHeight(): Int {
        return height.toInt()
    }
}