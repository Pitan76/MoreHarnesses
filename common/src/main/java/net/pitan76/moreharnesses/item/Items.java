package net.pitan76.moreharnesses.item;

import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.pitan76.mcpitanlib.api.item.v2.ItemSettingsBuilder;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;

import static net.pitan76.moreharnesses.MoreHarnesses._id;
import static net.pitan76.moreharnesses.MoreHarnesses.registry;

public class Items {

    public static final ItemSettingsBuilder STANDARD_ITEM_SETTINGS = ItemSettingsBuilder.of()
            .addGroup(ItemGroups.MORE_HARNESSES);

    public static RegistryResult<Item> IRON_HARNESS;
    public static RegistryResult<Item> GOLDEN_HARNESS;
    public static RegistryResult<Item> DIAMOND_HARNESS;

    public static void init() {
        IRON_HARNESS = registry.registerItem(_id("iron_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("iron_harness")), DyeColor.WHITE, 0.05d));
        GOLDEN_HARNESS = registry.registerItem(_id("golden_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("golden_harness")), DyeColor.YELLOW, 0.075d));
        DIAMOND_HARNESS = registry.registerItem(_id("diamond_harness"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("diamond_harness")), DyeColor.LIGHT_BLUE, 0.1d));
    }
}
