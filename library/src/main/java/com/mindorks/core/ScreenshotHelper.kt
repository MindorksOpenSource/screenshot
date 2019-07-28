package com.mindorks.core

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate

class ScreenshotHelper(private val activity: Activity) {

    private var quality = Quality.HIGH
    private var flip = Flip.NOTHING
    private var rotate = Rotate.DEGREE_0

    fun setQuality(quality: Quality): ScreenshotHelper {
        this.quality = quality
        return this;
    }

    fun setFlip(flip: Flip): ScreenshotHelper {
        this.flip = flip
        return this
    }

    fun setRotation(rotate: Rotate): ScreenshotHelper {
        this.rotate = rotate
        return this
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
