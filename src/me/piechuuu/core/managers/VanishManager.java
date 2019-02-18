package me.piechuuu.core.managers;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class VanishManager {
	private static final Map<String, Player> players = new HashMap<>();
	public static void addPlayer(final Player p) {
		players.put(p.getName(), p);
	}
	public static void removePlayer(final Player p) {
		players.remove(p.getName());
	}
	public static Boolean isVanish(final Player p) {
		return Boolean.valueOf(players.containsKey(p.getName()));
	}
}
