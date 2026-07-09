package com.theendercore.all_fours.net.packets

import com.theendercore.all_fours.AllFours.id
import com.theendercore.all_fours.player.ExtraInputData
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

data class ServerboundExtraPlayerInputPacket(val input: ExtraInputData) : CustomPacketPayload {

    override fun type() = ID

    companion object {

        val ID = CustomPacketPayload.Type<ServerboundExtraPlayerInputPacket>(id("extra_player_input"))

        val STREAM_CODEC: StreamCodec<FriendlyByteBuf, ServerboundExtraPlayerInputPacket> = StreamCodec.composite(
            ExtraInputData.STREAM_CODEC,
            ServerboundExtraPlayerInputPacket::input,
            ::ServerboundExtraPlayerInputPacket
        )

    }
}