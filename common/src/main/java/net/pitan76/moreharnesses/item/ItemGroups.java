package net.pitan76.moreharnesses.item;

import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;
import net.pitan76.mcpitanlib.api.util.ItemStackUtil;

import static net.pitan76.moreharnesses.MoreHarnesses._id;
import static net.pitan76.moreharnesses.MoreHarnesses.registry;

public class ItemGroups {

    public static CreativeTabBuilder MORE_HARNESSES = CreativeTabBuilder.create(_id("main"))
            .setIcon(() -> ItemStackUtil.create(Items.DIAMOND_HARNESS.get()));

    public static void init() {
        registry.registerItemGroup(MORE_HARNESSES);
    }
}
