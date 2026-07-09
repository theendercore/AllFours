package com.theendercore.all_fours.mixin.client;

import com.theendercore.all_fours.client.player.ExtraInput;
import com.theendercore.all_fours.net.packets.ServerboundExtraPlayerInputPacket;
import com.theendercore.all_fours.player.AllFoursPlayer;
import com.theendercore.all_fours.player.ExtraInputData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.player.ClientInput;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin implements AllFoursPlayer {

    @Shadow
    public ClientInput input;
    @Unique
    private final ExtraInput all_fours$extraInputs = new ExtraInput();
    @Unique
    private ExtraInputData all_fours$lastExtraInputs = new ExtraInputData();

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isPassenger()Z"))
    void customTick(CallbackInfo ci) {
        if (!this.all_fours$lastExtraInputs.equals(all_fours$extraInputs.keyPresses)) {
            ClientPlayNetworking.send(new ServerboundExtraPlayerInputPacket(all_fours$extraInputs.keyPresses));
            all_fours$lastExtraInputs = all_fours$extraInputs.keyPresses;
        }
    }

    @Inject(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/ClientInput;tick()V", shift = At.Shift.AFTER))
    void tickCustomInput(CallbackInfo ci) {
        all_fours$extraInputs.tick(input.getMoveVector().length());
    }

    @Inject(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;canStartSprinting()Z"))
    void customAiStep(CallbackInfo ci) {
        all_fours_setCrawling(all_fours$extraInputs.keyPresses.crawling());
        all_fours_setSitting(all_fours$extraInputs.keyPresses.sitting() && !(input.getMoveVector().length() > 0));
    }

}