package com.theendercore.all_fours.config

import me.fzzyhmstrs.fzzy_config.annotations.NonSync
import me.fzzyhmstrs.fzzy_config.config.Config
import me.fzzyhmstrs.fzzy_config.config.ConfigGroup
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedNumber.WidgetType.TEXTBOX_WITH_BUTTONS
import com.theendercore.all_fours.AllFours.MODID
import com.theendercore.all_fours.AllFours.id

@Suppress("unused")
class AllFoursConfig : Config(id(MODID)) {

    var groupName = ConfigGroup("group_id", false)

    var commonEntry = ValidatedInt(0, 10, -10, TEXTBOX_WITH_BUTTONS)

    @NonSync
    @ConfigGroup.Pop
    var clientEntry = true

}