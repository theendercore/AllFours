package com.theendercore.all_fours.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.theendercore.all_fours.AllFours;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.theendercore.all_fours.client.AllFoursClient.SITING_KEY;

@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin {

    @Inject(method = "setupRotations(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;FF)V", at = @At("HEAD"))
    void sittingOffset(AvatarRenderState state, PoseStack poseStack, float f, float g, CallbackInfo ci) {
        if (Boolean.TRUE.equals(state.getData(SITING_KEY))) {
            poseStack.translate(0.0F, -0.55f, 0.0F);
        }
    }
}
