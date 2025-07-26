package net.pitan76.moreharnesses.fabric;

import net.pitan76.moreharnesses.MoreHarnesses;
import net.fabricmc.api.ModInitializer;

public class MoreHarnessesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        new MoreHarnesses();
    }
}