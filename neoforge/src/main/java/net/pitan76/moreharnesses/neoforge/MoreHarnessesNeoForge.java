package net.pitan76.moreharnesses.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.pitan76.moreharnesses.MoreHarnesses;

@Mod(MoreHarnesses.MOD_ID)
public class MoreHarnessesNeoForge {
    public MoreHarnessesNeoForge(ModContainer modContainer) {
        IEventBus eventBus = modContainer.getEventBus();

        new MoreHarnesses();
    }
}