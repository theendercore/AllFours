package com.theendercore.all_fours.client

import com.theendercore.all_fours.AllFours
import com.theendercore.all_fours.client.init.AFKeys
import com.theendercore.all_fours.client.init.AFOptions
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey

object AllFoursClient {

    @JvmField
    val SITING_KEY = RenderStateDataKey.create<Boolean> { "all_fours:siting" }

    fun init() {
        AllFours.log.info("Hello from Client")
        AFOptions.init()
        AFKeys.init()
    }

}