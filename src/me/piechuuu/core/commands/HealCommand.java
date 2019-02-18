package me.piechuuu.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Ta komende moze wywolac tylko gracz");
            return false;
        }
        if (!commandSender.hasPermission("bapehc.core.heal")) {
            commandSender.sendMessage("§8» §4Blad: §cNie masz dostepu do §7(bapehc.core.heal)");
            return false;
        }
        if (strings.length == 0) {
            Player p = (Player) commandSender;
            p.setHealth(20);
            p.setFoodLevel(20);
            p.setFireTicks(0);
            p.sendMessage("§8» §cPomyslnie zostales §4uleczony");
            return true;
        }
        if (strings.length == 1) {
            Player cel = Bukkit.getPlayerExact(strings[0]);
            cel.setHealth(20);
            cel.setFoodLevel(20);
            cel.setFireTicks(0);
            cel.sendMessage("§8» §czostales uleczony przez §7" + commandSender.getName());
            commandSender.sendMessage("§8» §culeczyles gracza §7" + cel.getName());
            return true;
        } else {
            commandSender.sendMessage("§8» §cPodany gracz jest §4offline");
        }
        return false;
    }
}
