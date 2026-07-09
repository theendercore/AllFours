package com.theendercore.all_fours.client.init

import com.theendercore.all_fours.AllFours.MODID
import com.theendercore.all_fours.client.init.AFOptions.toggleCrawl
import com.theendercore.all_fours.client.init.AFOptions.toggleSit
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper.registerKeyBinding
import net.minecraft.client.KeyMapping.Category.MOVEMENT
import net.minecraft.client.ToggleKeyMapping
import org.lwjgl.glfw.GLFW

object AFKeys {

    val crawl =
        registerKeyBinding(ToggleKeyMapping("key.$MODID.crawl", GLFW.GLFW_KEY_C, MOVEMENT, toggleCrawl::get, true))
    val sit: ToggleKeyMapping = registerKeyBinding(
        ToggleKeyMapping(
            "key.$MODID.sit",
            GLFW.GLFW_KEY_Z,
            MOVEMENT,
            toggleSit::get,
            true
        )
    ) as ToggleKeyMapping

    fun init() = Unit

}