package com.theendercore.all_fours.util

import com.theendercore.all_fours.player.AllFoursPlayer
import net.minecraft.world.entity.player.Player


var Player.isCrawling: Boolean
    get() = afPlayer().all_fours_isCrawling()
    set(value) = afPlayer().all_fours_setCrawling(value)

var Player.isSitting: Boolean
    get() = afPlayer().all_fours_isSitting()
    set(value) = afPlayer().all_fours_setSitting(value)

fun Player.afPlayer() = (this as AllFoursPlayer)