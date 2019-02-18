package me.piechuuu.core.listener;

import me.piechuuu.core.managers.TpaManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if (event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) return;
		if (TpaManager.hasTimer(event.getPlayer())) {
			TpaManager.removeTimer(event.getPlayer());
			event.getPlayer().sendMessage(ChatColor.DARK_RED + "Blad: " + ChatColor.RED + "Teleportacja przerwana!");
		}
	}
}
