package com.theendercore.all_fours.mixin;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Avatar.class)
public class AvatarMixin {

    @SuppressWarnings("unchecked")
    @WrapOperation(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;"))
    private static <K, V> ImmutableMap<K, V> addPoses(ImmutableMap.Builder instance, Operation<ImmutableMap<K, V>> original) {
        instance.put(Pose.SITTING, EntityDimensions.scalable(0.6F, 1.3F).withEyeHeight(1.07F));
        return original.call(instance);
    }

}