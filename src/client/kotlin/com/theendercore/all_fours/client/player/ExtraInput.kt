package com.theendercore.all_fours.client.player

import com.theendercore.all_fours.client.init.AFKeys
import com.theendercore.all_fours.player.ExtraInputData

class ExtraInput(@JvmField var keyPresses: ExtraInputData) {

    constructor() : this(ExtraInputData())

    fun tick(moveVec: Float) {
        keyPresses = ExtraInputData(AFKeys.crawl.isDown, AFKeys.sit.isDown && !(moveVec > 0))
    }

}