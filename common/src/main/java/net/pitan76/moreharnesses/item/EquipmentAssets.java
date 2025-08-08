package net.pitan76.moreharnesses.item;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.pitan76.moreharnesses.util.EquipmentAssetUtil;

import static net.pitan76.moreharnesses.MoreHarnesses._id;

public class EquipmentAssets {

    public static RegistryKey<EquipmentAsset> COPPER_HARNESS = EquipmentAssetUtil.register(_id("copper_harness"));
    public static RegistryKey<EquipmentAsset> IRON_HARNESS = EquipmentAssetUtil.register(_id("iron_harness"));
    public static RegistryKey<EquipmentAsset> GOLD_HARNESS = EquipmentAssetUtil.register(_id("gold_harness"));
    public static RegistryKey<EquipmentAsset> DIAMOND_HARNESS = EquipmentAssetUtil.register(_id("diamond_harness"));
    public static RegistryKey<EquipmentAsset> EMERALD_HARNESS = EquipmentAssetUtil.register(_id("emerald_harness"));
    public static RegistryKey<EquipmentAsset> NETHERITE_HARNESS = EquipmentAssetUtil.register(_id("netherite_harness"));

    public static void init() {

    }
}
