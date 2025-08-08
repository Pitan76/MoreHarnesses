package net.pitan76.moreharnesses.item;

import net.minecraft.item.Item;
import net.pitan76.mcpitanlib.api.item.v2.ItemSettingsBuilder;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import net.pitan76.moreharnesses.Config;

import static net.pitan76.moreharnesses.MoreHarnesses._id;
import static net.pitan76.moreharnesses.MoreHarnesses.registry;

public class Items {

    public static final ItemSettingsBuilder STANDARD_ITEM_SETTINGS = ItemSettingsBuilder.of()
            .addGroup(ItemGroups.MORE_HARNESSES);

    public static RegistryResult<Item> COPPER_HARNESS;
    public static RegistryResult<Item> IRON_HARNESS;
    public static RegistryResult<Item> GOLD_HARNESS;
    public static RegistryResult<Item> DIAMOND_HARNESS;
    public static RegistryResult<Item> EMERALD_HARNESS;
    public static RegistryResult<Item> NETHERITE_HARNESS;

    public static void init() {
        COPPER_HARNESS = registry.registerItem(_id("copper_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("copper_harness")),
                EquipmentAssets.COPPER_HARNESS, Config.config.getDouble("copper_harness_speed"), Config.config.getDouble("copper_harness_armor")));
        IRON_HARNESS = registry.registerItem(_id("iron_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("iron_harness")),
                EquipmentAssets.IRON_HARNESS, Config.config.getDouble("iron_harness_speed"), Config.config.getDouble("iron_harness_armor")));
        GOLD_HARNESS = registry.registerItem(_id("gold_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("gold_harness")),
                EquipmentAssets.GOLD_HARNESS, Config.config.getDouble("gold_harness_speed"), Config.config.getDouble("gold_harness_armor")));
        DIAMOND_HARNESS = registry.registerItem(_id("diamond_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("diamond_harness")),
                EquipmentAssets.DIAMOND_HARNESS, Config.config.getDouble("diamond_harness_speed"), Config.config.getDouble("diamond_harness_armor")));
        EMERALD_HARNESS = registry.registerItem(_id("emerald_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("emerald_harness")),
                EquipmentAssets.EMERALD_HARNESS, Config.config.getDouble("emerald_harness_speed"), Config.config.getDouble("emerald_harness_armor")));
        NETHERITE_HARNESS = registry.registerItem(_id("netherite_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("netherite_harness")),
                EquipmentAssets.NETHERITE_HARNESS, Config.config.getDouble("netherite_harness_speed"), Config.config.getDouble("netherite_harness_armor")));
    }
}
