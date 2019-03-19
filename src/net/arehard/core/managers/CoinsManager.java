package net.arehard.core.managers;

import net.arehard.core.config.Config;

public class CoinsManager
{
    public static void setCoins(final String player, final int number) {
        Config.getConfig("coins").set("Gracz." + player + ".coins", (Object)number);
    }
    
    public static int getCoins(final String player) {
        final int coins = Config.getConfig("coins").getInt("Gracz." + player + ".coins");
        return coins;
    }
}