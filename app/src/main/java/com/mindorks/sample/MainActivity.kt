package com.mindorks.sample

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.mindorks.Flip
import com.mindorks.Screenshot
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val screenshot = Screenshot(this)
        Handler().postDelayed(Runnable { image.setImageBitmap(screenshot.getScreenshot(Flip.VERTICALLY)) }, 5000)

    }
}
