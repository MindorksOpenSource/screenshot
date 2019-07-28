package com.mindorks

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import com.mindorks.core.ScreenshotGenerator

class ScreenShott(private val activity: Activity) {

    private var quality = Quality.HIGH
    private var flip = Flip.NOTHING

    fun setQuality(quality: Quality): ScreenShott {
        this.quality = quality
        return this;
    }

    fun setFlip(flip: Flip): ScreenShott {
        this.flip = flip
        return this
    }

    fun getScreenshot(): Bitmap {
        return ScreenshotGenerator(activity)
            .setQuality(quality)
            .setFlip(flip)
            .getScreenshot()
    }

    fun getScreenshot(view: View): Bitmap {
        return ScreenshotGenerator(activity)
            .setView(view)
            .setQuality(quality)
            .setFlip(flip)
            .getScreenshot()
    }


}
