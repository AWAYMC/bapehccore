package me.piechuuu.core.managers;

import me.piechuuu.core.CorePlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpPlayer implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if(commandLabel.equalsIgnoreCase("tp")) {
		}
		
		if (!(sender.hasPermission("bapehc.core.tp"))) {
			sender.sendMessage("§4Blad§8:§cNie masz uprawnien do §7(bapehc.core.tp)");
			return false;
		}
		if(args.length == 0) {
			p.sendMessage("§4Blad§8:§cPoprawne uzycie§8: §7/tp <nick>");
	}else if(args.length == 1) {
		Player targetPlayer = p.getServer().getPlayer(args[0]);
		Location targetPlayerLocation = targetPlayer.getLocation();
		p.teleport(targetPlayerLocation);
		p.sendMessage(CorePlugin.prefix + " §cPomyslnie przeteleportowano do " + targetPlayer.getName() + " " );
	}else if(args.length== 2) {
		Player targetPlayer = p.getServer().getPlayer(args[0]);
		Player targetPlayer2 = p.getServer().getPlayer(args[0]);
		Location targetPlayer2Location = targetPlayer2.getLocation();
		targetPlayer.teleport(targetPlayer2Location);
	}else {
		sender.sendMessage("§4Blad§8:§cPodany gracz jest offline");
	}
		return false;
	}
}
