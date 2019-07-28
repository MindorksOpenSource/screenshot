package com.mindorks.properties

/**
 * Quality returns the quality of bitmap
 */
enum class Quality(val quality: Int) {

    HIGH(100),
    MEDIUM(75),
    AVERAGE(50),
    LOW(25)
}