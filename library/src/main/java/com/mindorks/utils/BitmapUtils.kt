package com.mindorks.utils

import android.app.Activity
import android.graphics.*
import android.net.Uri
import android.view.View
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate
import java.io.*

/**
 * @BitmpaUtils have all the bitmap properties and operations
 */
object BitmapUtils {
    /**
     * @flip is an extension function which flips the bitmap
     */
    private fun flip(bitmap: Bitmap, flip: Flip): Bitmap {
        val cx = bitmap.width / 2f
        val cy = bitmap.height / 2f
        return when (flip) {
            Flip.HORIZONTALLY -> bitmap.flip(-1f, 1f, cx, cy)
            Flip.VERTICALLY -> bitmap.flip(1f, -1f, cx, cy)
            Flip.NOTHING -> bitmap

        }
    }

    /**
     * @rotate is an extension function which rotates the bitmap
     */
    private fun rotateBitmap(bitmap: Bitmap, rotate: Rotate): Bitmap = bitmap.rotate(rotate.rotationDegree)


    private fun Bitmap.flip(x: Float, y: Float, cx: Float, cy: Float): Bitmap {
        val matrix = Matrix().apply { postScale(x, y, cx, cy) }
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }

    private fun Bitmap.rotate(degrees: Float): Bitmap {
        val matrix = Matrix().apply { postRotate(degrees) }
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }

    /**
     * @getScreenshot()
     * @return Bitmap
     * @param view
     * @param rotate
     * @param quality
     * @param flip
     */
    fun getAsBitmap(
        activity: Activity,
        view: View,
        rotate: Rotate,
        quality: Quality,
        flip: Flip
    ): Bitmap {

        val stream = ByteArrayOutputStream()
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) bgDrawable.draw(canvas)
        else canvas.drawColor(Color.WHITE)
        view.draw(canvas)
        returnedBitmap.run {
            compress(Bitmap.CompressFormat.JPEG, quality.quality, stream as OutputStream?)
        }
        val byteArray = stream.toByteArray()
        val bitmapAfterFlip = flip(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size), flip)
        return rotateBitmap(bitmapAfterFlip, rotate)

    }

    fun getAsImageFile(
        activity: Activity,
        view: View,
        rotate: Rotate,
        quality: Quality,
        flip: Flip,
        path: File
    ): Uri {
        val pathOfFile = File(path, "images")
        pathOfFile.mkdirs()
        val file: File = File("$pathOfFile/${System.currentTimeMillis()}_image.png")
        try {
            val stream = FileOutputStream(file)
            getAsBitmap(activity, view, rotate, quality, flip).compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()
            stream.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)

    }

    fun getAsImageFile(
        activity: Activity,
        view: View,
        rotate: Rotate,
        quality: Quality,
        flip: Flip
    ): Uri {
        val cachePath = File(activity.cacheDir, "images")
        cachePath.mkdirs()
        try {
            val stream = FileOutputStream("$cachePath/image.png")
            getAsBitmap(activity, view, rotate, quality, flip).compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }
        // Return the saved bitmap uri
        return Uri.parse(cachePath.absolutePath)

    }


}