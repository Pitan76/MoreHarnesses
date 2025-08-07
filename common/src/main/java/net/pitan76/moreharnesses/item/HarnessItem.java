package net.pitan76.moreharnesses.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.pitan76.mcpitanlib.api.item.v2.CompatibleItemSettings;
import net.pitan76.moreharnesses.util.EquipmentAssetUtil;

public class HarnessItem extends Item {

    private final double additionalSpeed;

    public HarnessItem(CompatibleItemSettings settings, RegistryKey<EquipmentAsset> key, double additionalSpeed) {
        super(settings.build().component(DataComponentTypes.EQUIPPABLE, EquipmentAssetUtil.ofHarness(key)));
        this.additionalSpeed = additionalSpeed;
    }

    public double getAdditionalSpeed() {
        return additionalSpeed;
    }
}
