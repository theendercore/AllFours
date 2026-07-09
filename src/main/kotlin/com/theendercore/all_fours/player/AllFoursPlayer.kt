package com.theendercore.all_fours.player

@Suppress("FunctionName")
interface AllFoursPlayer {

    fun all_fours_isCrawling(): Boolean
    fun all_fours_setCrawling(value: Boolean)

    fun all_fours_isSitting(): Boolean
    fun all_fours_setSitting(value: Boolean)

}