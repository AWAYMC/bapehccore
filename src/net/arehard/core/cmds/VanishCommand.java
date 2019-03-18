package net.arehard.core.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.arehard.core.ChatUtil.ChatUtil;
import net.arehard.core.managers.VanishManager;


public class VanishCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) return ChatUtil.sendMessage(sender, "&8>> &cTej komendy nie mozna uzyc z poziomu konsoli!");
		if(!sender.hasPermission("vanish.core.pvp")) {
			ChatUtil.sendMessage(sender, "&8>> &4Blad: &cNie masz dostepu do &7(vanish.core.pvp)");
		}
		final Player player = (Player) sender;
		final Boolean b = VanishManager.isVanish(player);
		if (!b) VanishManager.addPlayer(player);
		else VanishManager.removePlayer(player);
		ChatUtil.vanish(player, b, "&8>> &cAdministrator &7"+player.getName()+" &7jest: &7"+ (b ? "&aWIDZIALNY" : "&cNIE WIDZIALNY"));
		return false;
	}
}
