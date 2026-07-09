package com.theendercore.all_fours.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.theendercore.all_fours.player.AllFoursPlayer;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public abstract class PlayerMixin implements AllFoursPlayer {

    @Unique
    private boolean all_fours$crawling = false;
    @Unique
    private boolean all_fours$sitting = false;


    @Override
    public boolean all_fours_isCrawling() {
        return all_fours$crawling;
    }

    @Override
    public void all_fours_setCrawling(boolean value) {
        all_fours$crawling = value;
    }

    @Override
    public boolean all_fours_isSitting() {
        return all_fours$sitting;
    }

    @Override
    public void all_fours_setSitting(boolean value) {
        all_fours$sitting = value;
    }

    @ModifyReturnValue(method = "getDesiredPose", at = @At("RETURN"))
    Pose setCustomPoses(Pose original) {
        return switch (original) {
            case CROUCHING, STANDING ->
                    (all_fours_isCrawling()) ? Pose.SWIMMING : all_fours_isSitting() ? Pose.SITTING : original;

            default -> original;
        };
    }
}
