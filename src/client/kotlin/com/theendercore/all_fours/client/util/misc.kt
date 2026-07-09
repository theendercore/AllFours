package com.theendercore.all_fours.client.util

import com.theendercore.all_fours.client.init.AFOptions
import net.minecraft.client.OptionInstance

fun appendToOptionsMenu(original: Array<OptionInstance<*>>): Array<out OptionInstance<*>> {
    val list = original.toMutableList()
    list.add(2, AFOptions.toggleCrawl)
    list.add(3, AFOptions.toggleSit)
    return list.toTypedArray()
}
