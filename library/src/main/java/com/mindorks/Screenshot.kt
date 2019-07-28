package com.mindorks

import android.app.Activity

/*
 * @author Himanshu-Singh
 * Initialise the class by passing the reference of activity
 */
object Screenshot {

    fun with(activity: Activity): ScreenShott {
        return ScreenShott(activity)
    }


}
