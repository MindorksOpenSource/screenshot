package com.mindorks.core

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate

class ScreenshotHelper constructor(private val activity: Activity) {

    private var quality = Quality.HIGH
    private var flip = Flip.NOTHING
    private var rotate = Rotate.DEGREE_0


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
            .setQuality(quality)
            .setRotation(rotate)
            .setFlip(flip)
            .getScreenshot()
    }

    fun getScreenshot(view: View): Bitmap {
        return ScreenshotGenerator(activity)
            .setView(view)
            .setRotation(rotate)
            .setQuality(quality)
            .setFlip(flip)
            .getScreenshot()
    }


}
