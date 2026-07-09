package com.theendercore.all_fours.client.init

import com.theendercore.all_fours.AllFours.MODID
import net.minecraft.client.OptionInstance
import net.minecraft.network.chat.Component

object AFOptions {

    val KEY_TOGGLE = Component.translatable("options.key.toggle")
    val KEY_HOLD = Component.translatable("options.key.hold")

    @JvmField
    val toggleCrawl = OptionInstance.createBoolean(
        "key.$MODID.crawl",
        OptionInstance.noTooltip(),
        { _, isToggle -> if (isToggle) KEY_TOGGLE else KEY_HOLD },
        false
    ) {}

    @JvmField
    val toggleSit = OptionInstance.createBoolean(
        "key.$MODID.sit",
        OptionInstance.noTooltip(),
        { _, isToggle -> if (isToggle) KEY_TOGGLE else KEY_HOLD },
        true
    ) {}

    fun init() = Unit
}