package net.arehard.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.arehard.core.ChatUtil.*;

public class FlyCommands implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
    	if(cmd.getName().equalsIgnoreCase("fly")) {
    		if (!(sender instanceof Player)) {
                sender.sendMessage("ONLY PLAYER!");
                return true;
            }
            if (!sender.hasPermission("arehard.core.fly")) {
                sender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawnien (arehard.core.fly)"));
                return true;
            }
            if (args.length == 0) {
                final Player p = (Player)sender;
                if (p.getAllowFlight()) {
                    p.sendMessage(ChatUtil.fixColor("&8>> &7Fly zostal: &cWYLACZONY!"));
                    p.setAllowFlight(false);
                    p.setFlying(false);
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&8>> &7Fly zostal: &cWLACZONY!"));
                    p.setAllowFlight(true);
                    p.setFlying(true);
                }
            }
            else if (args.length == 1) {
                final Player pArg = Bukkit.getPlayerExact(args[0]);
                if (pArg == null) {
                    sender.sendMessage(ChatUtil.fixColor("&4Blad: &cGracz jest OFFLINE!"));
                    return true;
                }
                if (pArg.getAllowFlight()) {
                    pArg.setFlying(false);
                    pArg.setAllowFlight(false);
                    sender.sendMessage(ChatUtil.fixColor("&8>> &7Tryb latania dla gracza &c" + pArg.getName() + " &7zostal &cWYLACZONY!"));
                }
                else {
                    pArg.setFlying(true);
                    pArg.setAllowFlight(true);
                    sender.sendMessage(ChatUtil.fixColor("&8>> &7Tryb latania dla gracza &c" + pArg.getName() + " &7zostal &cWLACZONY!"));
                }
            }
        }
		return false;
    }
}