package com.cn.horizon.life.activity

import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import com.cn.horizon.life.R
import com.cn.horizon.life.app.base.BaseActivity
import com.cn.horizon.life.widgets.fresco.DrawablePostprocessor
import com.cn.horizon.life.widgets.fresco.HalfCircleDrawable
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //图片地址
        var url: String = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy" +
                "/it/u=3276424759,4034967609&fm=26&gp=0.jpg"
        var imageRequest: ImageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url!!))
                .setPostprocessor(object : DrawablePostprocessor() {
                    override fun createDrawable(width: Float, height: Float): Drawable {
                        //五角星
                        //return FivePointedStarDrawable(width, height)
                        //菱形
//                        return DiamondDrawable(width, height)
                        //半圆
                        return HalfCircleDrawable(width, height)
                        //平行四边形
//                        return ParallelogramDrawable(width, height)
                    }
                }).build()
        var controller: DraweeController = Fresco.newDraweeControllerBuilder().setImageRequest(imageRequest)
                .setOldController(iv_image.controller).build()
        iv_image.controller = controller
        iv_image_origin.setImageURI(Uri.parse(url))
    }
}
