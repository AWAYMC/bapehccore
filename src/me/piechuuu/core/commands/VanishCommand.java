package me.piechuuu.core.commands;

import me.piechuuu.core.managers.VanishManager;
import me.piechuuu.core.vanish.utils.ChatUtil;
import me.piechuuu.core.vanish.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return ChatUtil.sendMessage(commandSender, "§8>> &cTej komendy nie mozna uzyc z poziomu konsoli!");
        if(!commandSender.hasPermission("bapehc.core.vanish")){
            commandSender.sendMessage(ChatUtil.fixColor("§4Blad: §cNie masz dostepu do §7(bapehc.core.vanish)"));
            return false;
        }
        final Player player = (Player) commandSender;
        final Boolean b = VanishManager.isVanish(player);
        if (!b) VanishManager.addPlayer(player);
        else VanishManager.removePlayer(player);
        Utils.vanish(player, b, "§8>> §cAdministrator &7"+player.getName()+" §7jest: &7"+ (b ? "§aWIDZIALNY" : "§cNIE WIDZIALNY"));
        return false;
    }
}

