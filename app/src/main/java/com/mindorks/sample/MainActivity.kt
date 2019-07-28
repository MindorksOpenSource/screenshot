package com.mindorks.sample

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
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
                    .setView(view)
                    .setQuality(Quality.AVERAGE)
                    .setRotation(Rotate.DEGREE_0)
                    .setFlip(Flip.HORIZONTALLY)
                    .getScreenshot()
            )
        }, 2000)

    }

}
