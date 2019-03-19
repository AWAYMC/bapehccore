package net.arehard.core.yaml;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.arehard.core.Main;

public class Config
{
    public static String ytMsg;
    public static String deleteCmd;
    public static String completeCmd;
    public static String prefix;
    public static String apiKey;
    public static String title;
    public static String validMsg;
    public static int iloscSubskrybcji;
    
    public static void loadMessages() {
        final JavaPlugin plugin = Main.getProvidingPlugin(Main.class);
        final FileConfiguration config = plugin.getConfig();
        final StringBuilder sb = new StringBuilder();
        for (final String s : config.getStringList("ytMessage")) {
            sb.append(s).append("\n");
        }
        Config.ytMsg = sb.toString();
        Config.deleteCmd = config.getString("deleteCmd");
        Config.completeCmd = config.getString("completeCmd");
        Config.prefix = config.getString("prefix");
        Config.apiKey = config.getString("apiKey");
        Config.title = config.getString("videoTitle");
        Config.validMsg = config.getString("validMsg");
        Config.iloscSubskrybcji = config.getInt("minSubs");
    }
}
