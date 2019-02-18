package me.piechuuu.core.commands;

import me.piechuuu.core.managers.TpaManager;
import me.piechuuu.core.teleport.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TpDenyCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
		if (!(commandSender instanceof Player)) return true;
		Player player = (Player) commandSender;
		if (TpaManager.getPlayer(player) == null) {
			player.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz oczekujacej prosby o teleportacje!"));
			return true;
		}
		Player other = TpaManager.getPlayer(player);
		if (other == null) {
			player.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz oczekujacej prosby o teleportacje!"));
			return true;
		}
		if ((System.currentTimeMillis() - (TpaManager.getRequestTime(other))) / 1000L <= 60L) {
			TpaManager.removeRequest(other, player);
			other.sendMessage(ChatUtil.fixColor("&4Blad: &cGracz " + player.getName() + " nie zaakceptowal twojej prosby o teleportacje!"));
			return true;
		}else {
			player.sendMessage(ChatUtil.fixColor("&4Blad: &cNie masz oczekujacej prosby o teleportacje!"));
			TpaManager.removeRequest(other, player);
		}
		return false;
	}
}
