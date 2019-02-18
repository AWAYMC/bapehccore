package me.piechuuu.core.commands;

import me.piechuuu.core.managers.TpaManager;
import me.piechuuu.core.teleport.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
		if (!(commandSender instanceof Player)) return true;
		Player player = (Player) commandSender;
		if (strings.length == 0) {
			player.sendMessage(ChatUtil.fixColor("&8>> &7Poprawne uzycie: &3/tpa <nick>"));
			return true;
		}
		Player other = Bukkit.getPlayer(strings[0]);
		if (other == null) {
			player.sendMessage(ChatUtil.fixColor("&4Blad: &cPodany gracz jest offline!"));
			return true;
		}
		player.sendMessage(ChatUtil.fixColor("&8>> &7Pomyslnie wyslano prosbe o teleportacje do gracza &2" + other.getName() + " &7!"));
		other.sendMessage(ChatUtil.fixColor("&8>> &7Gracz &2" + player.getName() + " &7chce sie do ciebie przeteleportowac!"));
		other.sendMessage(ChatUtil.fixColor("&8>> &7&a/tpaccept &7aby zaakceptowac teleportacje!"));
		other.sendMessage(ChatUtil.fixColor("&8>> &7&c/tpdeny &7aby odrzucic teleportacje!"));
		TpaManager.sendRequest(player, other);
		return false;
	}
}
