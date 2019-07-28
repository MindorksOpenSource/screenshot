package com.mindorks

import android.app.Activity
import com.mindorks.core.ScreenshotBuilder

/*
 * @author Himanshu-Singh
 * Initialise using Screenshot.with(activityReference)
 */
object Screenshot {

    fun with(activity: Activity): ScreenshotBuilder = ScreenshotBuilder(activity)

}
