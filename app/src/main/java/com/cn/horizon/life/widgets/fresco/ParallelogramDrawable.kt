package com.cn.horizon.life.widgets.fresco

import android.graphics.Canvas
import android.graphics.Path

/**
 * Created by horizony on 2017/8/31.
 */
class ParallelogramDrawable constructor(width: Float, height: Float) : ShapeDrawable(width, height) {
    init {
        super.width = width
        super.height = height
    }

    override fun draw(canvas: Canvas?) {
        var path: Path = Path()
        path.moveTo(0F, width / 6)
        path.lineTo(width, 0F)
        path.lineTo(width, height - width / 6)
        path.lineTo(0F, height)
        path.close()
        canvas?.drawPath(path, paint)
    }

}