package net.pitan76.moreharnesses.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.HappyGhastEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.moreharnesses.MoreHarnesses;
import net.pitan76.moreharnesses.item.HarnessItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HappyGhastEntity.class)
public class HappyGhastEntityMixin {

    @Unique
    private static final CompatIdentifier moreHarnesses$id = MoreHarnesses._id("flying_speed");

    @Inject(method = "addPassenger(Lnet/minecraft/entity/player/PlayerEntity;)V", at = @At("TAIL"))
    private void addPassenger(PlayerEntity player, CallbackInfo ci) {
        HappyGhastEntity entity = (HappyGhastEntity) (Object) this;
        ItemStack stack = entity.getBodyArmor();
        if (!(stack.getItem() instanceof HarnessItem item)) return;

        EntityAttributeInstance flyingSpeed = entity.getAttributeInstance(EntityAttributes.FLYING_SPEED);
        if (flyingSpeed == null) return;
        if (flyingSpeed.hasModifier(moreHarnesses$id.toMinecraft())) return;

        EntityAttributeModifier modifier = new EntityAttributeModifier(
                moreHarnesses$id.toMinecraft(),
                item.getAdditionalSpeed(),
                EntityAttributeModifier.Operation.ADD_VALUE
        );
        flyingSpeed.addPersistentModifier(modifier);
    }


    @Inject(method = "addPassenger(Lnet/minecraft/entity/Entity;)V", at = @At("TAIL"))
    private void addPassenger(Entity passenger, CallbackInfo ci) {
        HappyGhastEntity entity = (HappyGhastEntity) (Object) this;
        ItemStack stack = entity.getBodyArmor();
        if (!(stack.getItem() instanceof HarnessItem item)) return;

        EntityAttributeInstance flyingSpeed = entity.getAttributeInstance(EntityAttributes.FLYING_SPEED);
        if (flyingSpeed == null) return;
        if (flyingSpeed.hasModifier(moreHarnesses$id.toMinecraft())) return;

        EntityAttributeModifier modifier = new EntityAttributeModifier(
                moreHarnesses$id.toMinecraft(),
                item.getAdditionalSpeed(),
                EntityAttributeModifier.Operation.ADD_VALUE
        );
        flyingSpeed.addPersistentModifier(modifier);
    }

    @Inject(method = "removePassenger", at = @At("TAIL"))
    private void removePassenger(Entity passenger, CallbackInfo ci) {
        HappyGhastEntity entity = (HappyGhastEntity)(Object)this;
        EntityAttributeInstance flyingSpeed = entity.getAttributeInstance(EntityAttributes.FLYING_SPEED);
        if (flyingSpeed == null) return;
        if (flyingSpeed.hasModifier(moreHarnesses$id.toMinecraft())) {
            flyingSpeed.removeModifier(moreHarnesses$id.toMinecraft());
        }
    }
}
