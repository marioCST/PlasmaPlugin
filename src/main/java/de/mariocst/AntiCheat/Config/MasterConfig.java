package de.mariocst.AntiCheat.Config;

import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;
import de.mariocst.MarioMain;

public class MasterConfig {
    private static MasterConfig masterConfig;

    private ConfigSection config;

    private Boolean isEmpty;

    private boolean isDown;

    private boolean invalidItemEnchantmentCheck;

    public MasterConfig(ConfigSection configSection) {
        masterConfig = this;
        config = configSection;
        isEmpty = config.isEmpty();
        init();
    }

    private void init() {
        if (!isEmpty) {
            invalidItemEnchantmentCheck = config.getBoolean("invalidItemEnchantmentCheck");
            isDown = config.isBoolean("isDown");
        } else {
            spawnDefaultConfig();
        }
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public static MasterConfig getMasterConfig() {
        return masterConfig;
    }

    private void spawnDefaultConfig() {
        MarioMain.getInstance().getLogger().notice("Erstelle default Config.");
        invalidItemEnchantmentCheck = true;
        isDown = false;
        save();
    }

    public void save() {
        try {
            config.put("invalidItemEnchantmentCheck", invalidItemEnchantmentCheck);
            config.put("isDown", isDown);
            Config c = new Config(MarioMain.getInstance().getDataFolder() + "/config.yml", Config.YAML);
            c.setAll(config);
            c.save();
        } catch (NullPointerException e) {
            spawnDefaultConfig();
            save();
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean getInvalidItemEnchantmentCheck() {
        return invalidItemEnchantmentCheck;
    }
}
