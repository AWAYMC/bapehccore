package me.piechuuu.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class GodCommand implements CommandExecutor {

    private Map<String, Integer> gody = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Do tego ma dostep tylko gracz");
            return false;
        }

        if (!commandSender.hasPermission("bapehc.core.god")) {
            commandSender.sendMessage("§4Blad: §cNie masz dostepu do §7(bapehc.core.god)");
            return false;
        }
        if (strings.length == 0) {
            Player p = (Player) commandSender;
            if (gody.containsKey(p.getName())) {
                gody.remove(p.getName());
                p.sendMessage("§cPomyslnie wylaczono §4Goda");
                return true;
            } else {
                gody.put(p.getName(), 1);
                p.sendMessage("§cPomyslnie wlaczono §4Goda");
                return true;
            }
        }
        if (strings.length == 1) {
            Player p = (Player) commandSender;
            if (!gody.containsKey(p.getName())) {
                gody.remove(p.getName());
                p.sendMessage("§cPomyslnie wylaczono §4Goda");
                return true;
            } else {
                gody.put(p.getName(), 1);
                p.sendMessage("§cPomyslnie wlaczono §4Goda");
                return true;
            }
        }
        return false;
    }
}
