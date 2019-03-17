package net.arehard.core.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.managers.CoinsManager;

public class CoinsCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    	Player p = (Player) commandSender;
        if (!commandSender.hasPermission("arehard.core.coins")) {
            commandSender.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz uprawien (arehard.core.coins)"));
            return false;
        }
        if (strings.length == 0) {
            commandSender.sendMessage(ChatUtil.fixColor("&8>> &7Twoje coins'y &c " + CoinsManager.getCoins(p.getName())));
            return true;
        }
        return false;
    }
}