package com.theendercore.all_fours.data.tags

import net.minecraft.core.registries.Registries
import com.theendercore.all_fours.AllFours.id
import com.theendercore.all_fours.util.tag

object AFBlockTags {

    val APPLE_LIKE = create("apple_like")

    fun create(id: String) = Registries.BLOCK.tag(id(id))

}