package net.pitan76.moreharnesses.item;

import net.pitan76.mcpitanlib.api.entity.attribute.*;
import net.pitan76.mcpitanlib.api.item.ArmorEquipmentType;
import net.pitan76.mcpitanlib.api.item.equipment.CompatEquipmentAsset;
import net.pitan76.mcpitanlib.api.item.equipment.EquippableComponentBuilder;
import net.pitan76.mcpitanlib.api.item.v2.CompatItem;
import net.pitan76.mcpitanlib.api.item.v2.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.sound.CompatSoundEvents;
import net.pitan76.moreharnesses.MoreHarnesses;

public class HarnessItem extends CompatItem {

    private final double additionalSpeed;

    public HarnessItem(CompatibleItemSettings settings, CompatEquipmentAsset asset, double additionalSpeed, double additionalArmor) {
        super(settings.equipable(new EquippableComponentBuilder(ArmorEquipmentType.BODY)
                        .equipSound(CompatSoundEvents.ENTITY_HAPPY_GHAST_EQUIP)
                        .model(asset)
                        .allowedEntities("can_equip_harness")
                        .equipOnInteract(true)
                        .canBeSheared(true)
                        .shearingSound(CompatSoundEvents.ENTITY_HAPPY_GHAST_UNEQUIP)
        ).attributeModifiers(
                new AttributeModifiersComponentBuilder().add(CompatEntityAttributes.ARMOR,
                        CompatEntityAttributeModifier.of(MoreHarnesses._id("armor"), additionalArmor, AttrModifierOperation.ADD),
                        CompatAttributeModifierSlot.BODY)
                )
        );
        this.additionalSpeed = additionalSpeed;
    }

    public HarnessItem(CompatibleItemSettings settings, CompatEquipmentAsset asset, double additionalSpeed) {
        this(settings, asset, additionalSpeed, 0.0);
    }

    public double getAdditionalSpeed() {
        return additionalSpeed;
    }
}
