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

    public static void init() {
        IRON_HARNESS = registry.registerItem(_id("example_item"), () -> new HarnessItem(STANDARD_ITEM_SETTINGS.build(_id("example_item"))));
    }
}
