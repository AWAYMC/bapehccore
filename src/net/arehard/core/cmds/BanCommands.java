package net.arehard.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.arehard.core.ChatUtil.ChatUtil;
 

public class BanCommands implements CommandExecutor {
	
	private net.arehard.core.Main plugin;
	 
    public void Main(net.arehard.core.Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("ban").setExecutor(this);
    }
 
 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("ban")) {
            if (args.length == 0) {
                sender.sendMessage(ChatUtil.fixColor("&4Blad: &cPoprawne uzycie: /ban <nick> <powod>"));
            } else if (args.length == 1) {
                sender.sendMessage(ChatUtil.fixColor("&4Blad: &cPodaj przyczyne zbanowania gracza!"));
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
 
                String banner = "Server";
 
                if (sender instanceof Player) {
                    banner = sender.getName();
                }
 
                target.kickPlayer(ChatColor.RED+"You have been banned from the server!\nBy: "+banner+"\nReason: "+x.toString().trim());
                plugin.getConfig().set("banned_players."+target.getName()+".banner", banner);
                plugin.getConfig().set("banned_players."+target.getName()+".reason", x.toString().trim());
                plugin.saveConfig();
 
                /**
                 * banned_players:
                 *    DeveloperB:
                 *      banner: Server
                 *      reason: You suck at coding
                 */
 
                sender.sendMessage(ChatColor.GREEN+"Successfully banned: "+target.getName());
            }
        }
 
        return true;
    }
}