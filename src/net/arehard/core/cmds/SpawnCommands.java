package net.arehard.core.cmds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import net.md_5.bungee.api.ChatColor;

public class SpawnCommands extends JavaPlugin implements Listener{

	private Map<Player, BukkitTask> tasks = new ConcurrentHashMap<>();
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if (event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) return;
		if (this.tasks.containsKey(event.getPlayer())) {
			this.tasks.remove(event.getPlayer()).cancel();
			event.getPlayer().sendMessage(ChatColor.DARK_RED + "Blad: " + ChatColor.RED + "Teleportacja przerwana!");
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setspawn")){
			double x = p.getLocation().getX();
			double y = p.getLocation().getY();
			double z = p.getLocation().getZ();
			String world = p.getWorld().getName();
			getConfig().set("spawn.x", x);
			getConfig().set("spawn.y", y);
			getConfig().set("spawn.z", z); 
			getConfig().set("spawn.world", world);
			saveConfig();
			p.sendMessage(ChatColor.DARK_GRAY + ">> " + ChatColor.DARK_GREEN + "Spawn zostal " + ChatColor.DARK_GREEN + "ustawiony");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (p.hasPermission("awaymc.spawn.bypass")) {
				p.sendMessage(ChatColor.DARK_GRAY + ">> " + ChatColor.DARK_GREEN + "Przeteleportowano!");
				p.teleport(new Location(Bukkit.getWorld(getConfig().getString("spawn.world")), getConfig().getInt("spawn.x"), getConfig().getInt("spawn.y"), getConfig().getInt("spawn.z")));
				return true;
			}else {
				p.sendMessage(ChatColor.DARK_GRAY + ">> " + ChatColor.DARK_GREEN + "Trwa teleportacja na spawn... (5 sekund)");
				BukkitTask task = getServer().getScheduler().runTaskLater(this, () -> {
					this.tasks.remove(p).cancel();
					p.sendMessage(ChatColor.DARK_GRAY + ">> " + ChatColor.DARK_GREEN + "Przeteleportowano!");
					p.teleport(new Location(Bukkit.getWorld(getConfig().getString("spawn.world")), getConfig().getInt("spawn.x"), getConfig().getInt("spawn.y"), getConfig().getInt("spawn.z")));
				}, 100L);
				this.tasks.put(p, task);
			}
			return true;
		}
		return false;
	}
}
	
	