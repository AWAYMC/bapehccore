package net.arehard.core.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.managers.VanishManager;

public class VanishListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final Player p = event.getPlayer();
		final Boolean b = VanishManager.isVanish(p);
		if (b) ChatUtil.vanish(p, b, "&8>> &cAdministrator &7"+p.getName()+" &7dolaczyl do serwera z wlaczonym vanishem!");
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent event) {
		if (VanishManager.isVanish(event.getPlayer())) event.setCancelled(true);
	}
}
