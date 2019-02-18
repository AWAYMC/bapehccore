package me.piechuuu.core.teleport.utils;

import org.bukkit.ChatColor;

public class ChatUtil {

	public static String fixColor(String msg) {
		if (msg == null) return "";
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
