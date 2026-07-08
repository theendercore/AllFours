package com.theendercore.all_fours.data.registry

import net.minecraft.core.registries.Registries
import com.theendercore.all_fours.AllFours
import com.theendercore.all_fours.util.key

object AFPaintings {

//    val APPLE_PAINT = create("apple_paint")

    fun create(id: String) = Registries.PAINTING_VARIANT.key(AllFours.id(id))

}