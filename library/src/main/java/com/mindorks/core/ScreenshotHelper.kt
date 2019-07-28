package com.mindorks.core

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import com.mindorks.properties.Default
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate

class ScreenshotHelper constructor(private val activity: Activity) {

    private var quality = Default.QUALITY_HIGH
    private var flip = Default.FLIP_VALUE
    private var rotate = Default.ROTATION_VALUE
    private var outputView = activity.window.decorView.rootView

    fun setView(view: View): ScreenshotHelper = apply {
        this.outputView = view
    }

    fun setQuality(quality: Quality): ScreenshotHelper = apply {
        this.quality = quality
    }

    fun setFlip(flip: Flip): ScreenshotHelper = apply {
        this.flip = flip
    }

    fun setRotation(rotate: Rotate): ScreenshotHelper = apply {
        this.rotate = rotate
    }

    fun getScreenshot(): Bitmap {
        return ScreenshotGenerator(activity)
            .setView(outputView)
            .setRotation(rotate)
            .setQuality(quality)
            .setFlip(flip)
            .getScreenshot()
    }


}
