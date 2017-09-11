package com.cn.horizon.life.widgets.fresco

import android.graphics.Canvas
import android.graphics.Path

/**
 * Created by horizony on 2017/8/31.
 */
class DiamondDrawable(width: Float, height: Float) : ShapeDrawable(width, height) {
    init {
        super.width = width
        super.height = height
    }

    override fun draw(canvas: Canvas?) {
        var path: Path = Path()
        var radio: Float = Math.min(width, height) / 2
        var centerX: Float = width / 2
        var centerY: Float = height / 2
        path.moveTo(centerX, centerY - radio)
        path.lineTo(centerX + radio, centerY)
        path.lineTo(centerX, centerY + radio)
        path.lineTo(centerX - radio, centerY)
        path.close()
        canvas?.drawPath(path, paint)
    }
}