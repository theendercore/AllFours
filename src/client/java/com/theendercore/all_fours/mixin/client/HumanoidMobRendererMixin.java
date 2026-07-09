package com.theendercore.all_fours.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.theendercore.all_fours.player.AllFoursPlayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.theendercore.all_fours.client.AllFoursClient.SITING_KEY;

@Mixin(HumanoidMobRenderer.class)
public class HumanoidMobRendererMixin {

    @ModifyExpressionValue(method = "extractHumanoidRenderState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isPassenger()Z"))
    private static boolean setIsSitting(boolean original, LivingEntity entity) {
        return original || entity.hasPose(Pose.SITTING);
    }

    @ModifyExpressionValue(method = "extractHumanoidRenderState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isCrouching()Z"))
    private static boolean posesOverrideCrouching(boolean original, LivingEntity entity) {
        if (entity instanceof AllFoursPlayer player && (player.all_fours_isSitting() || player.all_fours_isCrawling())) {
            return false;
        }
        return original;
    }

    @Inject(method = "extractHumanoidRenderState", at = @At("HEAD"))
    private static void extractExtraState(LivingEntity entity, HumanoidRenderState state, float f, ItemModelResolver itemModelResolver, CallbackInfo ci) {
        state.setData(SITING_KEY, entity.hasPose(Pose.SITTING));
    }

}