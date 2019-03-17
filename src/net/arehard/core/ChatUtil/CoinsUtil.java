package net.arehard.core.ChatUtil;

import org.bukkit.entity.Player;

import net.arehard.core.managers.CoinsManager;


public class CoinsUtil {
	
	public static void CoinsP(final Player p, final int amount) {
		CoinsManager.setCoins(p.getName(), CoinsManager.getCoins(p.getName()) + amount);
    }

}
