package com.theendercore.all_fours.player

import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import kotlin.experimental.or

@JvmRecord
data class ExtraInputData(val crawling: Boolean, val sitting: Boolean) {

    constructor() : this(false, false)

    companion object {

        val STREAM_CODEC = object : StreamCodec<FriendlyByteBuf, ExtraInputData> {
            @Suppress("KotlinConstantConditions")
            override fun encode(buf: FriendlyByteBuf, input: ExtraInputData) {
                var b: Byte = 0
                b = (b or (if (input.crawling) 1 else 0))
                b = (b or (if (input.sitting) 2 else 0))
                buf.writeByte(b.toInt())
            }

            override fun decode(buf: FriendlyByteBuf): ExtraInputData {
                val byte = buf.readByte()
                val crawling = (byte.toInt() and 1) != 0
                val sitting = (byte.toInt() and 2) != 0
                return ExtraInputData(crawling, sitting)
            }
        }

    }
}