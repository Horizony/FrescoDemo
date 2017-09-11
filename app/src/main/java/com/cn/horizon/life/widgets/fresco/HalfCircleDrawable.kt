package com.cn.horizon.life.widgets.fresco

import android.graphics.Canvas

/**
 * Created by horizony on 2017/8/31.
 */
class HalfCircleDrawable constructor(width: Float, height: Float) : ShapeDrawable(width, height) {
    init {
        super.width = width
        super.height = height
    }

    override fun draw(canvas: Canvas?) {
        canvas?.drawCircle(width / 2F, height, Math.min(width, height) / 2F, paint)
    }

}