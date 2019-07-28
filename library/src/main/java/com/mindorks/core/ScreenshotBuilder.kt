package com.mindorks.core

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import com.mindorks.utils.Default
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate

class ScreenshotBuilder constructor(private val activity: Activity) {

    private var quality = Default.QUALITY_VALUE
    private var flip = Default.FLIP_VALUE
    private var rotate = Default.ROTATION_VALUE
    private var outputView = activity.window.decorView.rootView

    fun setView(view: View): ScreenshotBuilder = apply {
        this.outputView = view
    }

    fun setQuality(quality: Quality): ScreenshotBuilder = apply {
        this.quality = quality
    }

    fun setFlip(flip: Flip): ScreenshotBuilder = apply {
        this.flip = flip
    }

    fun setRotation(rotate: Rotate): ScreenshotBuilder = apply {
        this.rotate = rotate
    }

    fun getScreenshot(): Bitmap {
        return ScreenshotHelper(activity)
            .setView(outputView)
            .setRotation(rotate)
            .setQuality(quality)
            .setFlip(flip)
            .getScreenshot()
    }


}
