package net.pitan76.moreharnesses.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.pitan76.mcpitanlib.api.item.v2.CompatibleItemSettings;

public class HarnessItem extends Item {

    private final float additionalSpeed;

    public HarnessItem(CompatibleItemSettings settings, DyeColor color, float additionalSpeed) {
        super(settings.build().component(DataComponentTypes.EQUIPPABLE, EquippableComponent.ofHarness(color)));
        this.additionalSpeed = additionalSpeed;
    }

    public float getAdditionalSpeed() {
        return additionalSpeed;
    }
}
