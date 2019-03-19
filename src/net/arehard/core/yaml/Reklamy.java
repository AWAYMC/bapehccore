package net.arehard.core.yaml;

import java.util.Hashtable;

import net.arehard.core.ChatUtil.ConfigReader;

public class Reklamy
{
    private static Hashtable<String, String> reklamy;
    private static ConfigReader cr;
    
    public static void loadReklamy() {
        Reklamy.reklamy = new Hashtable<String, String>();
        Reklamy.cr = new ConfigReader("reklamy.yml");
        if (Reklamy.cr.getConfig().getConfigurationSection("reklamy") == null) {
            return;
        }
        for (final String s : Reklamy.cr.getConfig().getConfigurationSection("reklamy").getKeys(true)) {
            Reklamy.reklamy.put(s, Reklamy.cr.getConfig().getString("reklamy." + s));
        }
    }
    
    public static String getPlayersReklama(final String player) {
        return Reklamy.reklamy.get(player);
    }
    
    public static void uploadReklama(final String player, final String link) {
        Reklamy.cr.getConfig().set("reklamy." + player, (Object)link);
        Reklamy.reklamy.put(player, link);
        Reklamy.cr.saveConfig();
    }
    
    public static void removeReklama(final String player) {
        Reklamy.reklamy.remove(player);
        Reklamy.cr.getConfig().set("reklamy." + player, (Object)null);
    }
    
    public static Hashtable<String, String> getReklamas() {
        return Reklamy.reklamy;
    }
    
    public static boolean isReklamaUsed(final String link) {
        for (final String s : Reklamy.reklamy.values()) {
            if (s.contains(link) || s.contains(link.split("=")[1])) {
                return true;
            }
        }
        return false;
    }
}
