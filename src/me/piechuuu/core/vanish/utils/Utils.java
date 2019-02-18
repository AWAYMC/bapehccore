package me.piechuuu.core.vanish.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {
	public static void vanish(final Player player, final Boolean b, final String m) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!b) p.hidePlayer(player);
			else p.showPlayer(player);
			if (p.isOp()) ChatUtil.sendMessage(p, m);
		}
	}
}
