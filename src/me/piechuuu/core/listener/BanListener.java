package me.piechuuu.core.listener;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class BanListener implements Listener {

    public void onJoin(PlayerJoinEvent e){
        Player p = (Player) e;
        File file = new File("plugins//BAPEHC_CORE//userdata//" + e.getPlayer().getName()+ ".yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if(cfg.getString("banned").equals("true")) {
            e.getPlayer().kickPlayer("§4BAN");
            e.getPlayer().kickPlayer("§czostales zbanowany");
            e.getPlayer().kickPlayer("§cPrzez §7" + e.getEventName());
            e.getPlayer().kickPlayer("§cPowod: §7");
            p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append("§cZbanowales gracza").append(p.getName()).toString());
        }
    }
}
