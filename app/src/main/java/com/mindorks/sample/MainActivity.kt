package com.mindorks.sample

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.Screenshot
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import com.mindorks.properties.Rotate
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(Runnable {
            image.setImageBitmap(

                Screenshot.with(this)
                    .setQuality(Quality.AVERAGE)
                    .setRotation(Rotate.DEGREE_90)
                    .setFlip(Flip.HORIZONTALLY)
                    .getScreenshot()
            )
        }, 2000)

    }

}
