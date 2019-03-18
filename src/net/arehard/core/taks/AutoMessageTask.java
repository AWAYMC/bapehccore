package net.arehard.core.taks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import net.arehard.core.Main;


public class AutoMessageTask extends BukkitRunnable{

	private Main plugin;
	private int id;
	
	public AutoMessageTask(Main plugin) {
		this.plugin = plugin;
		runTaskTimer(this.plugin, 1200L, 1200L);
	}
	
	@Override
	public void run() {
		if (this.plugin.getConfig().getStringList("Messages").size() == 0) return;
		if (id >= this.plugin.getConfig().getStringList("Messages").size()) id = 0;
		Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getStringList("Messages").get(id))));
		++id;
	}
}
