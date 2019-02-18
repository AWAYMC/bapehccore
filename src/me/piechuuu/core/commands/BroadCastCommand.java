package me.piechuuu.core.commands;

import me.piechuuu.core.CorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadCastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("bc")) {
            if(!(commandSender instanceof Player)) {
                if(strings.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < strings.length; i++) {
                        sb.append(strings[i]).append(" ");
                    }
                    String msg = sb.toString();
                    for(Player t : Bukkit.getOnlinePlayers()) {
                        t.sendMessage(CorePlugin.prefix + "§c " + msg);
                    }
                }
                else commandSender.sendMessage(CorePlugin.prefix + " §4Blad§8:§cPoprawne uzycie: §7/bc <wiadomosc>");
            }
            else {
                Player p = (Player) commandSender;
                if(p.hasPermission("bapehc.core.bc")) {
                    if(strings.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for(int i = 0; i < strings.length; i++) {
                            sb.append(strings[i]).append(" ");
                        }
                        String msg = sb.toString();
                        for(Player t : Bukkit.getOnlinePlayers()) {
                            t.sendMessage(CorePlugin.prefix + " " + msg);
                        }
                    }
                    else p.sendMessage(CorePlugin.prefix + " §4Blad§8:§cPoprawne uzycie: §7/bc <wiadomosc>");
                }
                else p.sendMessage(CorePlugin.prefix + " §4Blad§8:§cNie masz dostepu do §7(bapehc.core.bc)");
            }
        }
        return false;
    }

}
