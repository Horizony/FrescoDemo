package com.cn.horizon.life.widgets.fresco

import android.graphics.Canvas
import android.graphics.Path


/**
 * Created by horizony on 2017/8/31.
 */
class FivePointedStarDrawable constructor(width: Float, height: Float) : ShapeDrawable(width, height) {
    init {
        super.width = width
        super.height = height
    }

    override fun draw(canvas: Canvas?) {
        val path = Path()
        var radius = Math.min(width, height) / 2
        val radian = degree2Radian(36)// 36为五角星的角度
        val radius_in = (radius * Math.sin((radian / 2).toDouble()) / Math
                .cos(radian.toDouble())).toFloat() // 中间五边形的半径

        path.moveTo((radius * Math.cos((radian / 2).toDouble())).toFloat(), 0F)// 此点为多边形的起点
        path.lineTo((radius * Math.cos((radian / 2).toDouble()) + radius_in * Math.sin(radian.toDouble())).toFloat(),
                (radius - radius * Math.sin((radian / 2).toDouble())).toFloat())
        path.lineTo((radius.toDouble() * Math.cos((radian / 2).toDouble()) * 2.0).toFloat(),
                (radius - radius * Math.sin((radian / 2).toDouble())).toFloat())
        path.lineTo((radius * Math.cos((radian / 2).toDouble()) + radius_in * Math.cos((radian / 2).toDouble())).toFloat(),
                (radius + radius_in * Math.sin((radian / 2).toDouble())).toFloat())
        path.lineTo(
                (radius * Math.cos((radian / 2).toDouble()) + radius * Math.sin(radian.toDouble())).toFloat(), (radius + radius * Math.cos(radian.toDouble())).toFloat())
        path.lineTo((radius * Math.cos((radian / 2).toDouble())).toFloat(),
                (radius + radius_in).toFloat())
        path.lineTo(
                (radius * Math.cos((radian / 2).toDouble()) - radius * Math.sin(radian.toDouble())).toFloat(), (radius + radius * Math.cos(radian.toDouble())).toFloat())
        path.lineTo((radius * Math.cos((radian / 2).toDouble()) - radius_in * Math.cos((radian / 2).toDouble())).toFloat(),
                (radius + radius_in * Math.sin((radian / 2).toDouble())).toFloat())
        path.lineTo(0F, (radius - radius * Math.sin((radian / 2).toDouble())).toFloat())
        path.lineTo((radius * Math.cos((radian / 2).toDouble()) - radius_in * Math.sin(radian.toDouble())).toFloat(),
                (radius - radius * Math.sin((radian / 2).toDouble())).toFloat())

        path.close()// 使这些点构成封闭的多边形
        canvas!!.drawPath(path, paint)
    }

    fun degree2Radian(degree: Int): Float {
        return (Math.PI * degree / 180).toFloat()
    }
}