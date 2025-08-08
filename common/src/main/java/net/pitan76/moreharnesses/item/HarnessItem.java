package net.pitan76.moreharnesses.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.pitan76.mcpitanlib.api.item.v2.CompatibleItemSettings;
import net.pitan76.moreharnesses.MoreHarnesses;
import net.pitan76.moreharnesses.util.EquipmentAssetUtil;

public class HarnessItem extends Item {

    private final double additionalSpeed;

    public HarnessItem(CompatibleItemSettings settings, RegistryKey<EquipmentAsset> key, double additionalSpeed, double additionalArmor) {
        super(settings.build()
                .component(DataComponentTypes.EQUIPPABLE, EquipmentAssetUtil.ofHarness(key))
                .component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
                        AttributeModifiersComponent.builder()
                                .add(EntityAttributes.ARMOR,
                                        new EntityAttributeModifier(MoreHarnesses._id("armor").toMinecraft(), additionalArmor, Operation.ADD_VALUE)
                                        , AttributeModifierSlot.BODY)
                                .build()
                )
        );
        this.additionalSpeed = additionalSpeed;
    }

    public HarnessItem(CompatibleItemSettings settings, RegistryKey<EquipmentAsset> key, double additionalSpeed) {
        this(settings, key, additionalSpeed, 0.0);
    }

    public double getAdditionalSpeed() {
        return additionalSpeed;
    }
}
