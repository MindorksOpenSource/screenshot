package com.mindorks.core

import android.app.Activity
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
class ScreenshotBuilder constructor(val activity: Activity, builder: Builder) {

    private var quality: Quality = builder.quality
    private var flip: Flip = builder.flip
    private var rotate: Rotate = builder.rotate
    private var outputView: View = builder.outputView

    class Builder(
        val activity: Activity,
        var outputView: View = activity.window.decorView.rootView
    ) {

        var quality: Quality = Default.QUALITY_VALUE
        var flip: Flip = Default.FLIP_VALUE
        var rotate: Rotate = Default.ROTATION_VALUE

        fun setView(view: View): Builder = apply {
            this.outputView = view
        }

        fun setQuality(quality: Quality): Builder = apply {
            this.quality = quality
        }

        fun setFlip(flip: Flip): Builder = apply {
            this.flip = flip
        }

        fun setRotation(rotate: Rotate): Builder = apply {
            this.rotate = rotate
        }

        fun build() = ScreenshotBuilder(activity, this)

    }


    fun asBitmap() = BitmapUtils.getAsBitmap(
        activity,
        outputView,
        rotate,
        quality,
        flip
    )

    fun asImageFile(path: File) =
        BitmapUtils.getAsImageFile(
            activity,
            outputView,
            rotate,
            quality,
            flip,
            path
        )

    fun asImageFile() = BitmapUtils.getAsImageFile(
        activity, outputView,
        rotate,
        quality,
        flip
    )

}