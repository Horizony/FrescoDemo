package com.cn.horizon.life.widgets.fresco

import android.graphics.*
import android.graphics.drawable.Drawable
import com.facebook.imagepipeline.request.BasePostprocessor

/**
 * Created by horizony on 2017/8/31.
 */
abstract class DrawablePostprocessor : BasePostprocessor() {
    var paint: Paint? = null
    var drawable: Drawable? = null

    init {
        paint = Paint()
        paint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    }

    override fun process(destBitmap: Bitmap?, sourceBitmap: Bitmap?) {
        drawable = createDrawable(sourceBitmap!!.width.toFloat(), sourceBitmap!!.height.toFloat())
        var bitmap: Bitmap = Bitmap.createBitmap(sourceBitmap!!.width, sourceBitmap!!.height, Bitmap.Config.ARGB_8888)
        var canvas: Canvas = Canvas(bitmap)

        drawable!!.bounds.set(0, 0, sourceBitmap!!.width, sourceBitmap!!.height)
        drawable!!.draw(canvas)
        canvas.drawBitmap(sourceBitmap, 0f, 0f, paint)
        super.process(destBitmap, bitmap)
    }

    abstract fun createDrawable(width: Float, height: Float): Drawable
}