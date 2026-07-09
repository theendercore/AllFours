package com.theendercore.all_fours

import com.theendercore.all_fours.config.AllFoursConfig
import com.theendercore.all_fours.init.AFNet
import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.minecraft.resources.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object AllFours {

    const val MODID = "all_fours"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(AllFours::class.simpleName)

    @JvmField
    var config = ConfigApi.registerAndLoadConfig(::AllFoursConfig)

    fun init() {
        log.info("I love crawling in your walls!")
        AFNet.init()
    }

    fun id(namespace: String, path: String): Identifier = Identifier.fromNamespaceAndPath(namespace, path)
    fun mc(path: String): Identifier = Identifier.withDefaultNamespace(path)
    fun id(path: String) = id(MODID, path)

}