package me.piechuuu.core.vanish.utils;

import java.util.Collection;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtil {
	public static String fixColor(final String t) {
		return t.replace("&", "�").replace(">>", "�").replace("<<", "�");
	}
	public static Boolean sendMessage(final Player p, final String m) {
		p.sendMessage(fixColor(m));
		return false;
	}
	public static Boolean sendMessage(final CommandSender s, final String m) {
		s.sendMessage(fixColor(m));
		return false;
	}
	public static Boolean sendMessage(final Collection<? extends Player> p, final String m) {
		p.stream().forEach(cp -> sendMessage(cp, fixColor(m)));
		return false;
	}
}
