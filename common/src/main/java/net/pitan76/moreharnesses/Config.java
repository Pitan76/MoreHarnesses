package net.pitan76.moreharnesses;

import net.pitan76.easyapi.FileControl;
import net.pitan76.easyapi.config.JsonConfig;
import net.pitan76.mcpitanlib.api.util.PlatformUtil;

import java.io.File;

public class Config {

    public static File configDir = PlatformUtil.getConfigFolderAsFile();
    public static String fileName = MoreHarnesses.MOD_ID + ".json";

    public static JsonConfig config = new JsonConfig();

    public static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;
        config.setDouble("copper_harness_speed", 0.035d);
        config.setDouble("iron_harness_speed", 0.050d);
        config.setDouble("gold_harness_speed", 0.075d);
        config.setDouble("diamond_harness_speed", 0.100d);
        config.setDouble("emerald_harness_speed", 0.150d);
        config.setDouble("netherite_harness_speed", 0.150d);

        config.setDouble("copper_harness_armor", 1.0d);
        config.setDouble("iron_harness_armor", 2.0d);
        config.setDouble("gold_harness_armor", 1.5d);
        config.setDouble("diamond_harness_armor", 3.0d);
        config.setDouble("emerald_harness_armor", 3.0d);
        config.setDouble("netherite_harness_armor", 5.0d);

        if (!FileControl.fileExists(getConfigFile()))
            config.save(getConfigFile(), true);

        config.load(getConfigFile());
    }

    public static File getConfigFile() {
        return new File(configDir, fileName);
    }
}
