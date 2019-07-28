package com.mindorks.core

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.View
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.utils.BitmapUtils
import java.io.ByteArrayOutputStream

class ScreenshotGenerator(private val activity: Activity) {
    private var outputView = activity.window.decorView.rootView
    private var qualityOutput = 100
    private var flip = Flip.NOTHING
    fun setView(view: View): ScreenshotGenerator {
        this.outputView = view
        return this
    }

    fun setQuality(quality: Quality): ScreenshotGenerator {
        this.qualityOutput = when (quality) {
            Quality.LOW -> 25
            Quality.MEDIUM -> 75
            Quality.AVERAGE -> 50
            else -> 100
        }
        return this;
    }

    fun setFlip(flip: Flip): ScreenshotGenerator {
        this.flip = flip
        return this
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
        return BitmapUtils.flip(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size), flip)

    }


    fun getScreenshot(): Bitmap {
        return getScreenshot(outputView)
    }

}