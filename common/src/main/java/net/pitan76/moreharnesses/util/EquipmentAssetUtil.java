package net.pitan76.moreharnesses.util;

import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;

public class EquipmentAssetUtil {

    public static EquippableComponent ofHarness(RegistryKey<EquipmentAsset> key) {
        RegistryEntryLookup<EntityType<?>> registryEntryLookup = Registries.createEntryLookup(Registries.ENTITY_TYPE);
        return EquippableComponent.builder(EquipmentSlot.BODY)
                .equipSound(SoundEvents.ENTITY_HAPPY_GHAST_EQUIP)
                .model(key)
                .allowedEntities(registryEntryLookup.getOrThrow(EntityTypeTags.CAN_EQUIP_HARNESS))
                .equipOnInteract(true)
                .canBeSheared(true)
                .shearingSound(Registries.SOUND_EVENT.getEntry(SoundEvents.ENTITY_HAPPY_GHAST_UNEQUIP))
                .build();
    }

    public static RegistryKey<EquipmentAsset> register(CompatIdentifier id) {
        return register(id.toMinecraft());
    }

    public static RegistryKey<EquipmentAsset> register(Identifier id) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, id);
    }
}
