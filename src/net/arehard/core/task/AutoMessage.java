package net.arehard.core.task;

import net.arehard.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoMessage extends BukkitRunnable {

    private Main plugin;
    private int id;
    public AutoMessage(Main main) {
        this.plugin = plugin;
        runTaskTimer(this.plugin, 60L, 60L);
    }

    public void run(){
        if(this.plugin.getConfig().getStringList("Message").size() == 0) return;
        if(id >= this.plugin.getConfig().getStringList("Message").size()) id = 0;
        Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getStringList("Message").get(id))));
    }
}
