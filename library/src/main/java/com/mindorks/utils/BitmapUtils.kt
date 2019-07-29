package com.mindorks.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.view.View
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate
import java.io.ByteArrayOutputStream

object BitmapUtils {
    fun flip(bitmap: Bitmap, flip: Flip): Bitmap {
        val cx = bitmap.width / 2f
        val cy = bitmap.height / 2f
        return when (flip) {
            Flip.HORIZONTALLY -> bitmap.flip(-1f, 1f, cx, cy)
            Flip.VERTICALLY -> bitmap.flip(1f, -1f, cx, cy)
            Flip.NOTHING -> bitmap

        }
    }

    fun rotateBitmap(bitmap: Bitmap, rotate: Rotate): Bitmap = bitmap.rotate(rotate.rotationDegree)


    private fun Bitmap.flip(x: Float, y: Float, cx: Float, cy: Float): Bitmap {
        val matrix = Matrix().apply { postScale(x, y, cx, cy) }
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }

    private fun Bitmap.rotate(degrees: Float): Bitmap {
        val matrix = Matrix().apply { postRotate(degrees) }
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }

    fun getScreenshot(activity: Activity, view: View, rotate: Rotate, quality: Quality, flip: Flip): Bitmap {
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
            compress(Bitmap.CompressFormat.JPEG, quality.quality, stream)
        }
        val byteArray = stream.toByteArray()
        val bitmapAfterFlip = flip(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size), flip)
        return rotateBitmap(bitmapAfterFlip, rotate)

    }


}