package me.piechuuu.core.commands;

import me.piechuuu.core.managers.TpaManager;
import me.piechuuu.core.teleport.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpAcceptCommand implements CommandExecutor{

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
		TpaManager.removeRequest(other, player);
		player.sendMessage(ChatUtil.fixColor("&8>> &7Gracz &2" + other.getName() + " &7zaakceptowal twoja prosbe o teleportacje!"));
		other.sendMessage(ChatUtil.fixColor("&8>> &7Zaakceptowales prosbe o teleportacje gracza &2" + player.getName() + "&7!"));
		TpaManager.addTask(player, other);
		return false;
	}

}
