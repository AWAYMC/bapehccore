package net.arehard.core.cmds;

import net.arehard.core.*;
import net.arehard.core.ChatUtil.ChatUtil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
public class KickCommands implements CommandExecutor {
 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        // /kick DeveloperB You suck at coding
 
        if (label.equalsIgnoreCase("kick")) {
            if (args.length == 0) {
                sender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /kick <nick> <powod>"));
            } else if (args.length == 1) {
                sender.sendMessage(ChatUtil.fixColor("&4Blad: &cPodaj przyczyne wyrzucenia gracza!"));
            } else {
                Player target = Bukkit.getPlayer(args[0]);
 
                if (target == null) {
                    sender.sendMessage(ChatUtil.fixColor("&4Blad: &cTen gracz jest OFFLINE!"));
                    return true;
                }
 
                StringBuilder x = new StringBuilder();
 
                for (int i = 1; i < args.length; i++) {
                    x.append(args[i]+" ");
                }
 
                String kicker = "Server";
 
                if (sender instanceof Player) {
                    kicker = sender.getName();
                }
 
                target.kickPlayer(ChatUtil.fixColor("&7Zostales wyrzucony z serwera!\n&7Przez: &c"+kicker+"\n&7Powod: &c"+x.toString().trim() + "\n\n&fTeamSpeak3: &9TS.AREHARD.PL\n&fStrona WWW: &9WWW.AREHARD.PL\n&fFanPage: &9FB.AREHARD.PL"));
                sender.sendMessage(ChatUtil.fixColor("&8>> &7Wyrzuciles gracza: &c"+target.getName()));
            }
 
 
        }
 
        return true;
    }
}