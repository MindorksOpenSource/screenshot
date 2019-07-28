package com.mindorks.core

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.View
import com.mindorks.properties.Default
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate
import com.mindorks.utils.BitmapUtils
import java.io.ByteArrayOutputStream

class ScreenshotGenerator(activity: Activity) {
    private var qualityOutput = Default.QUALITY_VALUE
    private var flip = Default.FLIP_VALUE
    private var rotate = Default.ROTATION_VALUE
    private var outputView = activity.window.decorView.rootView

    fun setView(view: View): ScreenshotGenerator = apply {
        this.outputView = view
    }


    fun setQuality(quality: Quality): ScreenshotGenerator = apply {
        this.qualityOutput = when (quality) {
            Quality.LOW -> 25
            Quality.MEDIUM -> 75
            Quality.AVERAGE -> 50
            else -> 100
        }
    }

    fun setFlip(flip: Flip): ScreenshotGenerator = apply {
        this.flip = flip
    }

    fun setRotation(rotate: Rotate): ScreenshotGenerator = apply {
        this.rotate = rotate
    }

    private fun getScreenshot(view: View): Bitmap {
        val stream = ByteArrayOutputStream()
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        view.background.also {
            it.draw(canvas)
        }
        view.run {
            draw(canvas)
        }

        returnedBitmap.run {
            compress(Bitmap.CompressFormat.JPEG, qualityOutput, stream)
        }
        val byteArray = stream.toByteArray()
        val bitmapAfterFlip = BitmapUtils.flip(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size), flip)
        val bitmapAfterRotation = BitmapUtils.rotateBitmap(bitmapAfterFlip, rotate)
        return bitmapAfterRotation

    }

    fun getScreenshot(): Bitmap = getScreenshot(outputView)

}