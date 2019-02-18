package me.piechuuu.core.listener;

import me.piechuuu.core.CorePlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockedCmd implements Listener {

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent event){
        String cmd = event.getMessage();
        Player p = event.getPlayer();
        if(p.hasPermission("bapehc.core.access.blocked")) {
            return;
        }
        if(CorePlugin.cmd.contains(cmd)){
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',CorePlugin.getInstance().getConfig().getString("message")));
            event.setCancelled(true);
        }
    }
}
