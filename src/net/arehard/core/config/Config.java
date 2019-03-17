package net.arehard.core.config;

import org.bukkit.configuration.file.*;
import net.arehard.core.*;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class Config
{
    public static List<String> SETTINGS_VIP;
    public static List<String> SETTINGS_SPONSOR;

    static {
        Config.SETTINGS_VIP = Arrays.asList("test", "test", "test", "test","test","test","test","test","test");
        Config.SETTINGS_SPONSOR = Arrays.asList("test", "test", "test", "test","test","test","test","test","test");
    }

    public static void loadConfig() {
        try {
            Main.getPlugin().saveDefaultConfig();
            final FileConfiguration c = Main.getPlugin().getConfig();
            Field[] fields;
            for (int length = (fields = Config.class.getFields()).length, i = 0; i < length; ++i) {
                final Field f = fields[i];
                if (c.isSet("AreHard." + f.getName().toLowerCase().replace("_", "."))) {
                    f.set(null, c.get("AreHard." + f.getName().toLowerCase().replace("_", ".")));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveConfig() {
        try {
            final FileConfiguration c = Main.getPlugin().getConfig();
            Field[] fields;
            for (int length = (fields = Config.class.getFields()).length, i = 0; i < length; ++i) {
                final Field f = fields[i];
                c.set("AreHard." + f.getName().toLowerCase().replace("_", "."), f.get(null));
            }
            Main.getPlugin().saveConfig();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfig() {
        loadConfig();
        saveConfig();
    }
}