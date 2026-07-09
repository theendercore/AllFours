package com.theendercore.all_fours.init

import com.theendercore.all_fours.net.packets.ServerboundExtraPlayerInputPacket
import com.theendercore.all_fours.util.isCrawling
import com.theendercore.all_fours.util.isSitting
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking

object AFNet {
    fun init() {
        PayloadTypeRegistry.playC2S()
            .register(ServerboundExtraPlayerInputPacket.ID, ServerboundExtraPlayerInputPacket.STREAM_CODEC)


        ServerPlayNetworking.registerGlobalReceiver(ServerboundExtraPlayerInputPacket.ID) { packet, context ->
            val player = context.player()
            if (player.connection.hasClientLoaded()) {
                player.resetLastActionTime()
                player.isCrawling = packet.input.crawling
                player.isSitting = packet.input.sitting
            }
        }
    }
}