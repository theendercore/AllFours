package com.theendercore.all_fours.datagen.data.tags

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.minecraft.core.HolderLookup
import java.util.concurrent.CompletableFuture

class ItemTagsProvider(o: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>, blockTag: BlockTagProvider) :
    ItemTagProvider(o, p, blockTag) {

    override fun addTags(lookup: HolderLookup.Provider) {
//        copy(TemplateBlockTags.APPLE_LIKE, TemplateItemTags.APPLE_LIKE)

//        valueLookupBuilder(ItemTags.SWORDS).add(Items.APPLE)
    }

}