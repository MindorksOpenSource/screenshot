package com.mindorks.core

import android.app.Activity
import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate
import com.mindorks.utils.BitmapUtils
import com.mindorks.utils.Default
import java.io.File


/**
 * ScreenshotBuilder is the builder class for Screenshot builder.
 */
class ScreenshotBuilder constructor(private val activity: Activity) {

    private var quality = Default.QUALITY_VALUE
    private var flip = Default.FLIP_VALUE
    private var rotate = Default.ROTATION_VALUE
    private var share = false
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

    fun shareScreenshot(share: Boolean): ScreenshotBuilder = apply {
        this.share = share
    }

    fun getAsBitmap(): Bitmap {
        return BitmapUtils.getAsBitmap(activity, outputView, rotate, quality, flip)
    }

    fun getAsImageFile(path: File): Uri {

        return BitmapUtils.getAsImageFile(activity, outputView, rotate, quality, flip, path)
    }

    fun getAsImageFile(): Uri {
        return BitmapUtils.getAsImageFile(activity, outputView, rotate, quality, flip)
    }
}