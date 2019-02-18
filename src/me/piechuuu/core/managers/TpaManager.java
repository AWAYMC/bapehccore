package me.piechuuu.core.managers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import me.piechuuu.core.CorePlugin;
import me.piechuuu.core.teleport.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class TpaManager {
	
	private static Map<Player, BukkitTask> tasksMap = new ConcurrentHashMap<>();
	private static Map<Player, Player> requestMap = new ConcurrentHashMap<>();
	private static Map<Player, Long> timerMap = new ConcurrentHashMap<>();
	
	public static void sendRequest(Player sender, Player receiver) {
		requestMap.put(sender, receiver);
		requestMap.put(receiver, sender);
		timerMap.put(sender, System.currentTimeMillis());
		timerMap.put(receiver, System.currentTimeMillis());
	}
	
	public static void addTask(Player player, Player other) { 
		if (other.hasPermission("bapehc.core.tpa.bypass")) {
			other.teleport(player.getLocation());
			other.sendMessage(ChatUtil.fixColor("&8>> &7Przeteleportowano!"));
			return;
		}else {
			other.sendMessage(ChatUtil.fixColor("&8>> &7Trwa teleportacja do gracza " + player.getName() + "... &8(&75 sekund&8)"));
			BukkitTask task = CorePlugin.getInstance().getServer().getScheduler().runTaskLater(CorePlugin.getInstance(), () -> {
				removeTimer(other);
				other.teleport(player.getLocation());
				other.sendMessage(ChatUtil.fixColor("&8>> &7Przeteleportowano!"));
			}, 100L);
			tasksMap.put(other, task);
		}
	}
	
	public static void removeRequest(Player sender, Player receiver) {
		requestMap.remove(sender);
		requestMap.remove(receiver);
		timerMap.remove(sender);
		timerMap.remove(receiver);
	}
	
	public static void removeTimer(Player player) {
		tasksMap.remove(player).cancel();;
	}
	
	public static Player getPlayer(Player player) {
		return requestMap.get(player);
	}
	
	public static Long getRequestTime(Player player) {
		return timerMap.get(player);
	}
	
	public static boolean hasTimer(Player player) {
		return tasksMap.containsKey(player);
	}
}
