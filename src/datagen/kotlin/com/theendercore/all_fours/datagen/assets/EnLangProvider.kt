package com.theendercore.all_fours.datagen.assets

import com.theendercore.all_fours.client.init.AFKeys
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.HolderLookup
import net.minecraft.resources.Identifier
import java.util.concurrent.CompletableFuture

class EnLangProvider(var output: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>) :
    FabricLanguageProvider(output, p) {

    override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
        /* getModHolders(BuiltInRegistries.ITEM).forEach {
             gen.add(it.value(), genLang(it.key().identifier()))
         }
         getModHolders(BuiltInRegistries.BLOCK).forEach {
             trySafe { gen.add(it.value(), genLang(it.key().identifier())) }
         }*/

        listOf(AFKeys.crawl, AFKeys.sit).forEach {
            gen.add(it.name, genLang(it.name.split(".").last()))
        }

    }

    fun genLang(id: Identifier) = genLang(id.path)
    fun genLang(str: String): String = str.split("_").joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }


    fun trySafe(fn: () -> Unit) {
        try {
            fn()
        } catch (e: Exception) {
            if (output.isStrictValidationEnabled) {
                LOGGER.warn("Exception found when lang gen: ", e)
            }
        }
    }

}