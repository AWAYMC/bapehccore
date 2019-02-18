package me.piechuuu.core.commands;

import me.piechuuu.core.CorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

	private CraftPlayer pp;

	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
			if (command.getName().equalsIgnoreCase("kick")) {
				if(!(commandSender instanceof Player)) {
					commandSender.sendMessage("Ta komenda jest tylko dla admininstratora");
			}
				if (!(commandSender.hasPermission("bapehc.core.kick"))) {
					commandSender.sendMessage("§4Blad§8:§cNie masz uprawnien do §7(bapehc.core.kick)");
					return false;
			}
				if (strings.length == 0) {
					commandSender.sendMessage(new StringBuilder().append(ChatColor.RED).append("§4Blad§8:§cPoprawne uzycie§8: §7/kick <nick> <powod>").toString());
					return true;
				}
				Player pp = Bukkit.getServer().getPlayerExact(strings[0]);
				if (strings.length == 1) {
					if (pp != null) {
						pp.kickPlayer("§c§lBAPE§4§lHC.PL \n §cZostales wyrzucony z serwera \n §7przez§8: §c" + commandSender.getName() + " \n §7powod§8: §c");
						commandSender.sendMessage(new StringBuilder().append(ChatColor.GRAY).append("§cWyrzuciles gracza ")
								.append(pp.getName()).toString());
						for (int i = 0; i < 100; ++i) Bukkit.broadcastMessage("");
					}
						Bukkit.broadcastMessage("§8#####################################################");
						Bukkit.broadcastMessage(" §8» §7Uzytkownik §c" + strings[0] + " §7Zostal wyrzucony z serwera");
						Bukkit.broadcastMessage(" §8» §7przez §c " + commandSender.getName());
						Bukkit.broadcastMessage("§8#####################################################");
					} else {
						 commandSender.sendMessage("§4Blad§8:§cPodany gracz jest offline");
					}
				}
				if (strings.length >= 2) {
					if (pp != null) {
						StringBuilder str = new StringBuilder();
						for (int i = 1; i < strings.length; i++) {
							str.append(strings[i]).append(" ");
						}
						pp.kickPlayer(new StringBuilder().append(ChatColor.RED)
								.append("§c§lBAPEHC§4§lHC.PL \n §cZostales wyrzucony z serwera \n §7przez§8: §c" + commandSender.getName() + " \n �7powod�8: �c")
								.append(str.toString()).toString());
						commandSender.sendMessage(new StringBuilder().append(ChatColor.GRAY)
								.append(CorePlugin.prefix + "  §4Pomyslnie wyrzuciles gracz ").append(pp.getName())
								.append(" powod: ").append(str.toString()).toString());
						for (int i = 0; i < 100; ++i) Bukkit.broadcastMessage("");
					}
						Bukkit.broadcastMessage("§8#####################################################");
						Bukkit.broadcastMessage(" §8» §7Uzytkownik §c" + strings[0] + " §7Zostal wyrzucony z serwera");
						Bukkit.broadcastMessage(" §8» §7przez §c " + commandSender.getName());
						Bukkit.broadcastMessage("§8#####################################################");
					} else {
						commandSender.sendMessage("§4Blad§8:§cPodany gracz jest offline");
				}
				return false;
	}
}
