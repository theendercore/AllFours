package com.theendercore.all_fours.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.theendercore.all_fours.client.AllFoursClient.SITING_KEY;

@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin {

    @ModifyReturnValue(
            method = "getRenderOffset(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)Lnet/minecraft/world/phys/Vec3;",
            at = @At("RETURN")
    )
    Vec3 fixOffset(Vec3 original, AvatarRenderState state){
        if (Boolean.TRUE.equals(state.getData(SITING_KEY))) {
            return original.add(0f, -0.55f,0);
        }
        return original;
    }


    @Inject(
            method = "setupRotations(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;FF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;setupRotations(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;FF)V",
                    shift = At.Shift.AFTER
            )
    )
    void sittingOffset(AvatarRenderState state, PoseStack poseStack, float f, float g, CallbackInfo ci) {
        if (Boolean.TRUE.equals(state.getData(SITING_KEY))) {
            poseStack.translate(0.0F, Mth.lerp(state.swimAmount, 0.0F, 0.55f), 0.0F);
        }
    }
}
