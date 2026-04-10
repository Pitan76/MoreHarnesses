package net.pitan76.moreharnesses.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.happyghast.HappyGhast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.moreharnesses.MoreHarnesses;
import net.pitan76.moreharnesses.item.HarnessItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HappyGhast.class)
public class HappyGhastMixin {

    @Unique
    private static final CompatIdentifier moreHarnesses$id = MoreHarnesses._id("flying_speed");

    @Inject(method = "doPlayerRide(Lnet/minecraft/world/entity/player/Player;)V", at = @At("TAIL"))
    private void addPassenger(Player player, CallbackInfo ci) {
        HappyGhast entity = (HappyGhast) (Object) this;
        ItemStack stack = entity.getBodyArmorItem();
        if (!(stack.getItem() instanceof HarnessItem item)) return;

        AttributeInstance flyingSpeed = entity.getAttribute(Attributes.FLYING_SPEED);
        if (flyingSpeed == null) return;
        if (flyingSpeed.hasModifier(moreHarnesses$id.toMinecraft())) return;

        AttributeModifier modifier = new AttributeModifier(
                moreHarnesses$id.toMinecraft(),
                item.getAdditionalSpeed(),
                AttributeModifier.Operation.ADD_VALUE
        );
        flyingSpeed.addPermanentModifier(modifier);
    }


    @Inject(method = "addPassenger(Lnet/minecraft/world/entity/Entity;)V", at = @At("TAIL"))
    private void addPassenger(Entity passenger, CallbackInfo ci) {
        HappyGhast entity = (HappyGhast) (Object) this;
        ItemStack stack = entity.getBodyArmorItem();
        if (!(stack.getItem() instanceof HarnessItem item)) return;

        AttributeInstance flyingSpeed = entity.getAttribute(Attributes.FLYING_SPEED);
        if (flyingSpeed == null) return;
        if (flyingSpeed.hasModifier(moreHarnesses$id.toMinecraft())) return;

        AttributeModifier modifier = new AttributeModifier(
                moreHarnesses$id.toMinecraft(),
                item.getAdditionalSpeed(),
                AttributeModifier.Operation.ADD_VALUE
        );
        flyingSpeed.addPermanentModifier(modifier);
    }

    @Inject(method = "removePassenger", at = @At("TAIL"))
    private void removePassenger(Entity passenger, CallbackInfo ci) {
        HappyGhast entity = (HappyGhast)(Object)this;
        AttributeInstance flyingSpeed = entity.getAttribute(Attributes.FLYING_SPEED);
        if (flyingSpeed == null) return;
        if (flyingSpeed.hasModifier(moreHarnesses$id.toMinecraft())) {
            flyingSpeed.removeModifier(moreHarnesses$id.toMinecraft());
        }
    }
}
