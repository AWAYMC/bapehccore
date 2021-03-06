package net.arehard.core.cmds;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.arehard.core.ChatUtil.ChatUtil;


public class AlertCommands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("alert.pvp.core")) {
	}
		if (args.length < 2)
			return ChatUtil.sendMessage(sender,"&8>> &cPoprawne uzycie: &7/alert <chat/title/subtitle/actionbar> (wiadomosc)");
		String out = "";
		for (int i = 1; i < args.length; ++i)
			out += args[i] + " ";
		final String message = out;
		switch (args[0].toLowerCase()) {
		case "chat":
			return ChatUtil.sendMessage(Bukkit.getOnlinePlayers(), "&8[&4AREHARD&8] &c" + message);
		case "title":
			return ChatUtil.sendTitle(Bukkit.getOnlinePlayers(), "&8[&4AREHARD&8]", "&c" + message);
		case "subtitle":
			return ChatUtil.sendTitle(Bukkit.getOnlinePlayers(), "&8[&4AREHARD&8]", "&c" + message);
		case "actionbar":
			return ChatUtil.sendActionBar(Bukkit.getOnlinePlayers(), "&c" + message);
		}
		return false;
	}
}
