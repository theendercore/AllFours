package com.theendercore.all_fours.mixin.client.options;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.options.controls.ControlsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.theendercore.all_fours.client.util.MiscKt.appendToOptionsMenu;

@Mixin(ControlsScreen.class)
public class ControlsScreenMixin {

    @ModifyReturnValue(method = "options", at = @At("RETURN"))
    private static OptionInstance<?>[] addExtraOptions(OptionInstance<?>[] original) {
        return appendToOptionsMenu(original);
    }

}
