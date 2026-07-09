package com.theendercore.all_fours.mixin.client.options;

import com.theendercore.all_fours.client.init.AFOptions;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.theendercore.all_fours.AllFours.MODID;

@Mixin(Options.class)
public class OptionsMixin {

    @Inject(method = "processOptions", at = @At("TAIL"))
    private static void addExtraOptions(Options.FieldAccess fieldAccess, CallbackInfo ci) {
        fieldAccess.process(MODID + ".toggleCrawl", AFOptions.toggleCrawl);
        fieldAccess.process(MODID + ".toggleSit", AFOptions.toggleSit);
    }

}