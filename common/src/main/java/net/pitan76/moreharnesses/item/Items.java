package net.pitan76.moreharnesses.item;

import net.minecraft.item.Item;
import net.pitan76.mcpitanlib.api.item.v2.ItemSettingsBuilder;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;

import static net.pitan76.moreharnesses.MoreHarnesses._id;
import static net.pitan76.moreharnesses.MoreHarnesses.registry;

public class Items {

    public static final ItemSettingsBuilder STANDARD_ITEM_SETTINGS = ItemSettingsBuilder.of()
            .addGroup(ItemGroups.MORE_HARNESSES);

    public static RegistryResult<Item> IRON_HARNESS;
    public static RegistryResult<Item> GOLD_HARNESS;
    public static RegistryResult<Item> DIAMOND_HARNESS;

    public static void init() {
        IRON_HARNESS = registry.registerItem(_id("iron_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("iron_harness")), EquipmentAssets.IRON_HARNESS, 0.05d));
        GOLD_HARNESS = registry.registerItem(_id("gold_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("gold_harness")), EquipmentAssets.GOLD_HARNESS, 0.075d));
        DIAMOND_HARNESS = registry.registerItem(_id("diamond_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("diamond_harness")), EquipmentAssets.DIAMOND_HARNESS, 0.1d));
    }
}
