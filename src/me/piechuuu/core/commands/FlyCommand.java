package me.piechuuu.core.commands;

import me.piechuuu.core.CorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Do tego ma dostep tylko gracz");
            return false;
        }
        if (!commandSender.hasPermission("bapehc.core.fly")) {
            commandSender.sendMessage("§4Blad: §cNie masz dostepu do §7(bapehc.core.fly)");
            return false;
        }
        if (strings.length == 0) {
            Player p = (Player) commandSender;
            p.setAllowFlight(!p.getAllowFlight());
            p.sendMessage(CorePlugin.prefix + " §cPomyslnie " + (p.getAllowFlight() ? "wlaczono" : "wylaczono") + " §4latanie");
            return true;
        }
        Player cel = Bukkit.getPlayerExact(strings[0]);
        if(cel == null) {
            commandSender.sendMessage("§4Blad: §cPodany gracz jest §4offline");
            return true;
        }
        cel.setAllowFlight(!cel.getAllowFlight());
        cel.sendMessage(CorePlugin.prefix + " §cPomyslnie " + (cel.getAllowFlight() ? "wlaczono" : "wylaczono" + " §4latanie"));
        return false;
    }
}