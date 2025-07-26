package net.pitan76.moreharnesses.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.pitan76.moreharnesses.MoreHarnesses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreHarnesses.MOD_ID)
public class MoreHarnessesForge {
    public MoreHarnessesForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EventBuses.registerModEventBus(MoreHarnesses.MOD_ID, modEventBus);
        new MoreHarnesses();
    }
}