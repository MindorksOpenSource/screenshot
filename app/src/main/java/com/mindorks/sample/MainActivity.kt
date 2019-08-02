package com.mindorks.sample

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.Screenshot
import com.mindorks.properties.Flip
import com.mindorks.properties.Quality
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(Runnable {


            Log.d(
                "URLPATH", Screenshot.with(this)
                    .setView(view)
                    .setQuality(Quality.HIGH)
                    .setFlip(Flip.HORIZONTALLY)
                    .shareScreenshot(true)
                    .getAsImageFile().toString()
            )

        }, 2000)

    }

}
