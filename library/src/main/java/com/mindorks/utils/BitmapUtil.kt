package com.mindorks.utils

import android.graphics.Bitmap
import android.graphics.Matrix
import com.mindorks.Flip

object BitmapUtil {
    fun flip(bitmap: Bitmap, flip: Flip): Bitmap {
        val cx = bitmap.width / 2f
        val cy = bitmap.height / 2f
        return when (flip) {
            Flip.HORIZONTALLY -> bitmap.flip(-1f, 1f, cx, cy)
            Flip.VERTICALLY -> bitmap.flip(1f, -1f, cx, cy)
            Flip.NOTHING -> bitmap

        }
    }

    private fun Bitmap.flip(x: Float, y: Float, cx: Float, cy: Float): Bitmap {
        val matrix = Matrix().apply { postScale(x, y, cx, cy) }
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }

}