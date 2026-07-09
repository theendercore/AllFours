package com.theendercore.all_fours.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.theendercore.all_fours.util.MixinUtilKt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public class EntityMixin {

    @ModifyReturnValue(method = "isVisuallyCrawling", at = @At("RETURN"))
    boolean makeExtraCrawling(boolean original) {
        if (((Object) this) instanceof Player player) {
            return MixinUtilKt.isCrawling(player) || original;
        }
        return original;
    }
}
